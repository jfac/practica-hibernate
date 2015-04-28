package servlet.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		final String regexRFC = "^[A-Z]{3,4}+[0-9]{9}$";
		bean.BeanUser User = new bean.BeanUser();
		moderl.User.User mod = new moderl.User.User();
		String Nombre,apellidoPaterno, apellidoMaterno, RFC, email;
		Nombre = request.getParameter("Nombre");
		apellidoPaterno = request.getParameter("apellidoPaterno");
		apellidoMaterno = request.getParameter("apellidoMaterno");
		RFC = request.getParameter("RFC");
		email = request.getParameter("email");
		
		RequestDispatcher rd = null;
		boolean error=false;
		if(Nombre.isEmpty()){
			error = true;
			request.setAttribute("Nombre", "Nombre es requerido");
		}
		else if(!Nombre.isEmpty()){
			Nombre = capital(Nombre);
		}
		if(apellidoPaterno.isEmpty()){
			error = true;
			request.setAttribute("apellidoPaterno", "Apellido es requerido");
		}else{
			apellidoPaterno = capital(apellidoPaterno);
		}
		if(apellidoMaterno.isEmpty()){
			error = true;
			request.setAttribute("apellidoMaterno", "Apellido es requerido");
		}else{
			apellidoMaterno = capital(apellidoMaterno);
		}
		if(RFC.isEmpty()){
			error = true;
			request.setAttribute("RFC", "RFC es requerido");
		}
		else if(RFC.length()>13){
			error = true;
			request.setAttribute("RFC", "Revasa el limite permitido max 13");
		}
		else if(RFC.length()<13){
			error = true;
			request.setAttribute("RFC", "Faltan caracteres min 13");
		}
		else if(!RFC.isEmpty() && !RFC.matches(regexRFC)){
			error = true;
			request.setAttribute("RFC", "No tiene el formato correcto");
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
			if(mod.saveUser(User)>0){
				request.setAttribute("Succes","Se ha guardado correctamente :D");
				request.getRequestDispatcher("/SetUser.jsp").forward(request, response);
				
				//rd = getServletContext().getRequestDispatcher("/SetUser.jsp");
				//rd.forward(request, response);
			}
		}
		else
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
