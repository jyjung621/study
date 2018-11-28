package oracle.java.springMVCBoard.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import oracle.java.springMVCBoard.dao.BDao;
import oracle.java.springMVCBoard.dto.BDto;


public class BListCommand implements BCommand {

	@Override
	public void execute(Model model) {
		BDao dao = new BDao();
		ArrayList<BDto> dtos = dao.list();
		model.addAttribute("list", dtos);

	}

}
