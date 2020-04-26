package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Produto;

import service.ProdutoService;


@WebServlet(name = "ExcluirProduto.do", urlPatterns = { "/ExcluirProduto.do" })
public class ExcluirProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		

	    ProdutoService produtoService = new ProdutoService();
	  
	    ArrayList<Produto> listarProdutos = null;
		 
		listarProdutos = produtoService.listarProdutos ();
		
		
		
			
		response.setContentType ("text/html"); 
		
		
		PrintWriter saida = response.getWriter();
	
		saida.println ("<br>  <h3> Lista de Produtos </h3> ");
		
	    saida.println (" <br>" + " " );	  
	 
		saida.println ("<html>");
		saida.println ("<body>");
		saida.println ("<table>");
					
		saida.println ("<tr>");
		
		saida.println ("<th>Codigo</th>");
		saida.println ("<th>Nome</th>");
		saida.println ("<th>Descricao</th>");
		saida.println ("<th>Valor</th>");
		saida.println ("<th>Estoque</th>");
		saida.println ("<th>Excluir</th>");

		
	
		saida.println ("</tr>");
		
		

	    listarProdutos.forEach (
	    	p ->{
	    		
	    		
	    		
	    		saida.println ("<tr>");
		    	
	    		
	      		saida.println ("<td>" );
	    		
	    		saida.println(p.getCodigo());
	    		
	    		saida.println ("</td>");
	    		
	    		
	    		
	    		saida.println ("<td>");
	    		saida.println(p.getNome());
	    		saida.println ("</td>");
	    		
	    		
	    		saida.println ("<td>");
	    		saida.println(p.getDescricao());
	    		saida.println ("</td>");
	    		
	    		saida.println ("<td>");
	    		saida.println(p.getValor());
	    		saida.println ("</td>");
	    		
	    		saida.println ("<td>");
	    		saida.println(p.getEstoque());
	    		saida.println ("</td>");
	    		
	    		saida.println ("<td>");
	    		saida.println("<a href= 'ExcluirProduto.do?codigo="
	    				       + p.getCodigo() + " ' > Excluir </a>");
	    		
	    		
	    		saida.println ("</td>");
	    		
	   
	    		
	    	}
	    
	    );
	    
	    
	    saida.println ("</table>");
	   
		saida.println ("</body>");
		
		 saida.println ("</html>");
		 
	    	
		 
			
			int codigo = Integer.parseInt (request.getParameter ("codigo"));
			
			Produto produto = new Produto ();
			
			produto.setCodigo (codigo);
			
			
			produtoService.excluir(produto);
			
	    	
	
					
								
								saida.println ("<br> Exclusão realizada com sucesso!<br>");   
								
								saida.println (" <p>&#128517;</p>");
								
																         	
							   	saida.println ("<br><a href='Logoff.do'>Sair</a>");
							   	    
							   	saida.println (" <br>" + " " );	  
					
					}
			

	

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int codigo = Integer.parseInt(request.getParameter("codigo_produto"));
		String descricao = request.getParameter("descricao_produto");
		String nome = request.getParameter ("nome_produto");
		double valor = Double.parseDouble(request.getParameter("valor_produto"));
		int estoque = Integer.parseInt(request.getParameter("estoque_produto"));
		

		
		Produto produto = new Produto ();
		produto.setCodigo (codigo);
		produto.setNome(nome);
		produto.setDescricao (descricao);
		produto.setValor(valor);
		produto.setEstoque(estoque);
		
		ProdutoService produtoService = new ProdutoService ();
		produtoService.excluir (produto);
		


			
		
		


		
	}

}
