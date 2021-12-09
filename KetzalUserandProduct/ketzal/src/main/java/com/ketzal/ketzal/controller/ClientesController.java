package com.ketzal.ketzal.controller;

import com.ketzal.ketzal.ClientesService;
import com.ketzal.ketzal.model.clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/clientes")
@CrossOrigin("*")


public class ClientesController {

    private final ClientesService clientesService;
    @Autowired
    public ClientesController(ClientesService clientesService) {
        this.clientesService = clientesService;
    } // constructor
    @GetMapping
    public List<clientes> getAllClientes() {
        return clientesService.getAllClientes();
    }

    @GetMapping(path = "{idcontacto}") // api/clientes/1
    public clientes getCliente(@PathVariable("idcontacto") Long idcontacto) {
        return clientesService.getCliente(idcontacto);
    } // getCliente


    @DeleteMapping(path = "{idcontacto}") // api/clientes/1
    public void deleteClientes(@PathVariable("idcontacto") Long idcontacto) {
        clientesService.deleteClientes(idcontacto);
    } // deleteClientes

    @PostMapping
    public void addClientes(@RequestBody clientes cliente) {
        clientesService.addClientes(cliente);
    } // addClientes

    @PutMapping(path = "{idcontacto}")
    public void updateClientes(@PathVariable("idcontacto") Long idcontacto,
                               @RequestParam(required = false) String nombre,
                               @RequestParam(required = false) String correo,
                               @RequestParam(required = false) String telefono,
                               @RequestParam(required = false) String oldContrasena,
                               @RequestParam(required = false) String newContrasena) {
        clientesService.updateClientes(idcontacto, nombre, correo, telefono, oldContrasena, newContrasena);
    }


}
