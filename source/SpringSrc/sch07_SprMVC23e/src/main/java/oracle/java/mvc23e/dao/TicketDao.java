package oracle.java.mvc23e.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import oracle.java.mvc23e.dto.TicketDto;

public class TicketDao {
	
	JdbcTemplate template;
	
	TransactionTemplate transactionTemplate1;

	public TicketDao() {
		System.out.println("template --> " + template);
	}
	
	
	public void buyTicket(final TicketDto dto) {
		System.out.println("buyTicket()  start...");
		System.out.println("dto.getConsumerId() --> " + dto.getConsumerId());
		System.out.println("dto.getAmount() --> " + dto.getAmount());
		
									// 익명 Class
		transactionTemplate1.execute(new TransactionCallbackWithoutResult() {
			
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus arg0) {
				template.update(new PreparedStatementCreator() {
					
					@Override
					public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
						String query = "insert into card (consumerId, amount) values (?,?)";
						PreparedStatement pstmt = conn.prepareStatement(query);
						pstmt.setString(1, dto.getConsumerId());
						pstmt.setString(2, dto.getAmount());
						
						return pstmt;
					}
				});
				
				template.update(new PreparedStatementCreator() {
					
					@Override
					public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
						String query = "insert into ticket (consumerId, countnum) values (?,?)";
						PreparedStatement pstmt = conn.prepareStatement(query);
						pstmt.setString(1, dto.getConsumerId());
						pstmt.setString(2, dto.getAmount());
						
						return pstmt;
					}
				});
			}
		});
	}
	
	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public TransactionTemplate getTransactionTemplate1() {
		return transactionTemplate1;
	}

	public void setTransactionTemplate1(TransactionTemplate transactionTemplate1) {
		this.transactionTemplate1 = transactionTemplate1;
	}

	
	
	
}
