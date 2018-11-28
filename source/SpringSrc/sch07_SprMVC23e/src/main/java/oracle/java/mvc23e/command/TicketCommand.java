package oracle.java.mvc23e.command;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import oracle.java.mvc23e.dto.TicketDto;
import oracle.java.mvc23e.dao.TicketDao;

public class TicketCommand implements ITicketCommand {

	private TicketDao ticketDao;
	private TransactionTemplate transactionTemplate2;

	public TicketDao getTicketDao() {
		return ticketDao;
	}

	public void setTicketDao(TicketDao ticketDao) {
		this.ticketDao = ticketDao;
	}

	public TransactionTemplate getTransactionTemplate2() {
		return transactionTemplate2;
	}

	public void setTransactionTemplate2(TransactionTemplate transactionTemplate2) {
		this.transactionTemplate2 = transactionTemplate2;
	}

	@Override
	public void execute(final TicketDto ticketDto) {
//		ticketDto.setAmount("1");
//		ticketDao.buyTicket(ticketDto);
//		ticketDto.setAmount("8");
//		ticketDao.buyTicket(ticketDto);
		
		transactionTemplate2.execute(new TransactionCallbackWithoutResult() {
			
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
//				ticketDto.setAmount("1");
				
				ticketDao.buyTicket(ticketDto);
//				ticketDto.setAmount("8");
//				ticketDao.buyTicket(ticketDto);
				
			}
		});
	}
	 
}
