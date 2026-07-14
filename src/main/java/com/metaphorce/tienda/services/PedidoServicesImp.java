package com.metaphorce.tienda.services;

import com.metaphorce.tienda.Exceptions.ProductNotFoundException;
import com.metaphorce.tienda.entidades.DetallePedido;
import com.metaphorce.tienda.entidades.Pedido;
import com.metaphorce.tienda.repositories.PedidoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoServicesImp implements IPedidoServices{
    PedidoRepository pedidoRepository;

    @Autowired
    public PedidoServicesImp(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }

    @Override
    public Pedido obetnerPedido(int id) {
        Pedido pedido= pedidoRepository.findById(id).orElse(null);
        if(pedido==null){
            throw new ProductNotFoundException("Pedido no encontrado");
        }
        return pedido;
    }

    @Override
    @Transactional // Asegura que se guarde el pedido y todos sus detalles juntos
    public Pedido insertarPedido(Pedido pedido) {
        if (pedido.getDetalles() != null) {
            for (DetallePedido detalle : pedido.getDetalles()) {
                detalle.setPedido(pedido);
            }
        }
        return pedidoRepository.save(pedido);
    }

    @Override
    @Transactional
    public Pedido actualizarPedido(int id, Pedido pedido) {
        Pedido actual=pedidoRepository.findById(id).orElse(null);
        if (actual!=null){
            actual.setCliente(pedido.getCliente());
            if (pedido.getDetalles() != null) {
                pedido.getDetalles().forEach(detalle -> detalle.setPedido(actual));
                actual.setDetalles(pedido.getDetalles());
            }
            return pedidoRepository.save(actual);
        }
        throw new ProductNotFoundException("El producto que trata de eliminar no existe");
    }

    @Override
    public void eliminarPedido(int id) {
        Pedido actual=pedidoRepository.findById(id).orElse(null);
        if (actual==null) {
            throw new ProductNotFoundException("El producto que trata de eliminar no existe");
        }
        pedidoRepository.deleteById(id);
    }
}
