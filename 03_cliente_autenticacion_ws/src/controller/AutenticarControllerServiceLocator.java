/**
 * AutenticarControllerServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package controller;

public class AutenticarControllerServiceLocator extends org.apache.axis.client.Service implements controller.AutenticarControllerService {

    public AutenticarControllerServiceLocator() {
    }


    public AutenticarControllerServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public AutenticarControllerServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for AutenticarController
    private java.lang.String AutenticarController_address = "http://localhost:8080/02_autenticacion_ws/services/AutenticarController";

    public java.lang.String getAutenticarControllerAddress() {
        return AutenticarController_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String AutenticarControllerWSDDServiceName = "AutenticarController";

    public java.lang.String getAutenticarControllerWSDDServiceName() {
        return AutenticarControllerWSDDServiceName;
    }

    public void setAutenticarControllerWSDDServiceName(java.lang.String name) {
        AutenticarControllerWSDDServiceName = name;
    }

    public controller.AutenticarController getAutenticarController() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(AutenticarController_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getAutenticarController(endpoint);
    }

    public controller.AutenticarController getAutenticarController(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            controller.AutenticarControllerSoapBindingStub _stub = new controller.AutenticarControllerSoapBindingStub(portAddress, this);
            _stub.setPortName(getAutenticarControllerWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setAutenticarControllerEndpointAddress(java.lang.String address) {
        AutenticarController_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (controller.AutenticarController.class.isAssignableFrom(serviceEndpointInterface)) {
                controller.AutenticarControllerSoapBindingStub _stub = new controller.AutenticarControllerSoapBindingStub(new java.net.URL(AutenticarController_address), this);
                _stub.setPortName(getAutenticarControllerWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("AutenticarController".equals(inputPortName)) {
            return getAutenticarController();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://controller", "AutenticarControllerService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://controller", "AutenticarController"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("AutenticarController".equals(portName)) {
            setAutenticarControllerEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
