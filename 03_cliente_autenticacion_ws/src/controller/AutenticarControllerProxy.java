package controller;

public class AutenticarControllerProxy implements controller.AutenticarController {
  private String _endpoint = null;
  private controller.AutenticarController autenticarController = null;
  
  public AutenticarControllerProxy() {
    _initAutenticarControllerProxy();
  }
  
  public AutenticarControllerProxy(String endpoint) {
    _endpoint = endpoint;
    _initAutenticarControllerProxy();
  }
  
  private void _initAutenticarControllerProxy() {
    try {
      autenticarController = (new controller.AutenticarControllerServiceLocator()).getAutenticarController();
      if (autenticarController != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)autenticarController)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)autenticarController)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (autenticarController != null)
      ((javax.xml.rpc.Stub)autenticarController)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public controller.AutenticarController getAutenticarController() {
    if (autenticarController == null)
      _initAutenticarControllerProxy();
    return autenticarController;
  }
  
  public javabeans.Cliente obtenerCliente(java.lang.String user, java.lang.String pass) throws java.rmi.RemoteException{
    if (autenticarController == null)
      _initAutenticarControllerProxy();
    return autenticarController.obtenerCliente(user, pass);
  }
  
  public boolean autenticarCliente(java.lang.String user, java.lang.String pass) throws java.rmi.RemoteException{
    if (autenticarController == null)
      _initAutenticarControllerProxy();
    return autenticarController.autenticarCliente(user, pass);
  }
  
  
}