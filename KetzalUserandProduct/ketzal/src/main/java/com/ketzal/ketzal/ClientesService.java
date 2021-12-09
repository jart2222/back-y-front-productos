package com.ketzal.ketzal;

import com.ketzal.ketzal.model.clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ClientesService {
    private final ClientesRepository clientesRepository;

    @Autowired
    public ClientesService(ClientesRepository clientesRepository) {
        this.clientesRepository = clientesRepository;
    }
    public List<clientes> getAllClientes() {
        return clientesRepository.findAll();
    } // getAllClientes


    public clientes getCliente(Long idcontacto) {
        return clientesRepository.findById(idcontacto).orElseThrow(()-> new IllegalStateException("El cliente con el id: " + idcontacto + " no existe"));
    } // getCliente

    public void deleteClientes(Long idcontacto) {
        if (clientesRepository.existsById(idcontacto)) {
            clientesRepository.deleteById(idcontacto);
        } else {
            throw new IllegalStateException("El cliente con el id " + idcontacto + " no existe");
        }// else
    }

    public void addClientes(clientes cliente) {
        Optional<clientes> clientByName = clientesRepository.findByName(cliente.getNombre());
        if (clientByName.isPresent()) {
            throw new IllegalStateException("El cliente con el nombre [" + cliente.getNombre() + "] ya existe");
        }// isPresent

        clientesRepository.save(cliente);
    } //addCliente

    @Transactional
    public void updateClientes(Long idcontacto, String nombre, String correo, String telefono, String oldContrasena, String newContrasena) {
        clientes cliente = clientesRepository.findById(idcontacto).orElseThrow(()-> new IllegalStateException("El cliente con el id " + idcontacto + " no existe"));

        if (nombre != null)
            if ( (!nombre.isEmpty()) && (!nombre.equals(cliente.getNombre())) ) {
                cliente.setNombre(nombre);
            } // if nombre

        if (correo != null)
            if ( (!correo.isEmpty()) && (!correo.equals(cliente.getCorreo())) ) {
                cliente.setCorreo(correo);
            } // if correo

        if (telefono != null)
            if ( (!telefono.isEmpty()) && (!telefono.equals(cliente.getTelefono())) ) {
                cliente.setTelefono(telefono);
            } // if telefono

        if (cliente.getContrasena().equals(oldContrasena))
            cliente.setContrasena(newContrasena);
    }// updateClientes
}// class ClientesService







