/**
 * AutenticarController.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package controller;

public interface AutenticarController extends java.rmi.Remote {
    public javabeans.Cliente obtenerCliente(java.lang.String user, java.lang.String pass) throws java.rmi.RemoteException;
    public boolean autenticarCliente(java.lang.String user, java.lang.String pass) throws java.rmi.RemoteException;
}
