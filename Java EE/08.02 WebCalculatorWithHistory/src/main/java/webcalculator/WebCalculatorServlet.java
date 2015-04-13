package webcalculator;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/WebCalculator")
public class WebCalculatorServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		History history = new History();
		HttpSession session = req.getSession();
		if(req.getParameterMap().size()>2){
			NumberOperation operation = getParameters(req, resp);
			history.addToHistory(req,resp,operation);
		} else
		history.printHistory(history.getHistory(session), resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		History history = new History();
		HttpSession session = req.getSession();
		if(req.getParameterMap().size()>2){
			NumberOperation operation = getParameters(req, resp);
			history.addToHistory(req,resp,operation);
		} else {
		ArrayList<NumberOperation> operations = history.getHistory(session);
		history.printHistory(operations, resp);
		}
	}
	
	public NumberOperation getParameters(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		int operandOne = Integer.parseInt(req.getParameter("operandOne"));
		int operandTwo = Integer.parseInt(req.getParameter("operandTwo"));
		String op = req.getParameter("operation");
		NumberOperation operation = new NumberOperation();
		operation.setOperandOne(operandOne);
		operation.setOperandTwo(operandTwo);
		operation.setOperation(op);
		operation.calculate();
		return operation;
	}

}
