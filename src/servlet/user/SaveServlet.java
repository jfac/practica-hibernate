package servlet.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.UserException;

/**
 * Servlet implementation class SaveServlet
 */
@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		final String regex = "^[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$";
		bean.BeanUser User = new bean.BeanUser();
		moderl.User.User mod = new moderl.User.User();
		String Nombre,apellidoPaterno, apellidoMaterno, RFC, email;
		Nombre = request.getParameter("Nombre");
		apellidoPaterno = request.getParameter("apellidoPaterno");
		apellidoMaterno = request.getParameter("apellidoMaterno");
		RFC = request.getParameter("RFC");
		email = request.getParameter("email");
		RequestDispatcher rd;
		
		boolean Succes=false, error=false;
		if(Nombre.isEmpty()){
			error = true;
			request.setAttribute("Nombre", "Nombre es requerido");
		}
		else if(!Nombre.isEmpty()){
			String palabra;
			char[] caracters = null;
			boolean flag;
			StringBuffer buffer = new StringBuffer();
			String[] palabras = Nombre.split("[ ]");
			for(int j = 0; j<palabras.length; j++){
				if(palabras[j].equals("del")|| palabras[j].equals("de")){
					//Do nothing
					flag=false;
				}
				else{
					flag = true;
					palabra = palabras[j];
					caracters = palabra.toCharArray();
					caracters[0] = Character.toUpperCase(caracters[0]);
				}
				if(flag){
					palabra = String.valueOf(caracters);
					palabras[j]=palabra;
				}
				flag=false;
			}
			for(int i = 0; i<palabras.length; i++){
				buffer.append(palabras[i]).append("");
				if(i!=palabras.length-1){
					buffer.append(" ");
				}
			}
			Nombre = buffer.toString();
		}
		if(apellidoPaterno.isEmpty()){
			error = true;
			request.setAttribute("apellidoPaterno", "Apellido es requerido");
		}else{
			String palabra;
			char[] caracters = null;
			boolean flag;
			StringBuffer buffer = new StringBuffer();
			String[] palabras = apellidoPaterno.split("[ ]");
			for(int j = 0; j<palabras.length; j++){
				if(palabras[j].equals("del")|| palabras[j].equals("de")){
					//Do nothing
					flag=false;
				}
				else{
					flag = true;
					palabra = palabras[j];
					caracters = palabra.toCharArray();
					caracters[0] = Character.toUpperCase(caracters[0]);
				}
				if(flag){
					palabra = String.valueOf(caracters);
					palabras[j]=palabra;
				}
				flag=false;
			}
			for(int i = 0; i<palabras.length; i++){
				buffer.append(palabras[i]).append("");
				if(i!=palabras.length-1){
					buffer.append(" ");
				}
			}
			apellidoPaterno = buffer.toString();
		}
		if(apellidoMaterno.isEmpty()){
			error = true;
			request.setAttribute("apellidoMaterno", "Apellido es requerido");
		}else{
			capital(apellidoMaterno);
		}
		if(RFC.isEmpty()){
			error = true;
			request.setAttribute("RFC", "RFC es requerido");
		}
		if(email.isEmpty()|| !email.matches(regex)){
			error = true;
			request.setAttribute("email","El correo es incorrecto");
		}
		if(!error){
			User.setNombre(Nombre);
			User.setApellidoMaterno(apellidoMaterno);
			User.setApellidoPaterno(apellidoPaterno);
			User.setRFC(RFC);
			User.setCorreoElectronico(email);
			if(mod.saveUser(User)==0){
				Succes = true;
			}
		}
		if(Succes){
			request.setAttribute("Succes","Se ha guardado correctamente :D");
			rd = getServletContext().getRequestDispatcher("/SetUser.jsp");
			rd.forward(request, response);
		}else
		{
			request.setAttribute("err","Corregir los datos");
			rd = getServletContext().getRequestDispatcher("/SetUser.jsp");
			rd.forward(request, response);
		}
		
	}
	
	private String capital(String text){
		String palabra;
		char[] caracters = null;
		boolean flag;
		StringBuffer buffer = new StringBuffer();
		String[] palabras = text.split("[ ]");
		for(int j = 0; j<palabras.length; j++){
			if(palabras[j].equals("del")|| palabras[j].equals("de")){
				//Do nothing
				flag=false;
			}
			else{
				flag = true;
				palabra = palabras[j];
				caracters = palabra.toCharArray();
				caracters[0] = Character.toUpperCase(caracters[0]);
			}
			if(flag){
				palabra = String.valueOf(caracters);
				palabras[j]=palabra;
			}
			flag=false;
		}
		for(int i = 0; i<palabras.length; i++){
			buffer.append(palabras[i]).append("");
			if(i!=palabras.length-1){
				buffer.append(" ");
			}
		}
		return buffer.toString();
		
	}
}
