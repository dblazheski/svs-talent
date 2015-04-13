package webcalculator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class History {

	public void addToHistory(HttpServletRequest req, HttpServletResponse resp,NumberOperation operation) throws IOException{
		List<NumberOperation> operations;
		HttpSession session = req.getSession();
	     operations = getHistory(session);
	     operations.add(operation);
	     session.setAttribute("operations",operations);
	     resp.setContentType("text/html");
	     resp.getWriter().println("Result is :  " + operation.getResult()+"</br>");
	     printHistory(operations, resp);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<NumberOperation> getHistory(HttpSession session){
		ArrayList<NumberOperation> history = (ArrayList<NumberOperation>) session.getAttribute("operations");
		if(history == null) 
			return new ArrayList<NumberOperation>();
		return history;
	}
	
	public void printHistory(List<NumberOperation> operations, HttpServletResponse resp) throws IOException{
		for(NumberOperation operation : operations){
			int operandOne = operation.getOperandOne();
			int operandTwo = operation.getOperandTwo();
			String op = operation.getOperation();
			int result = operation.getResult();
	    	resp.getWriter().println(operandOne+" "+op+" "+operandTwo+" = "+result+"</br>");
	     }
	}
}
