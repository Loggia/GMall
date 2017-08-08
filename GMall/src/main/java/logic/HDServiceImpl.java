package logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.BoardDao;

@Service
public class HDServiceImpl implements HDService{
	
	@Autowired
	BoardDao boardDao;
	
	@Override
	public List<Product> primList() {
		return boardDao.primList();
	}

	@Override
	public List<Product> newList() {
		return boardDao.newList();
	}

	@Override
	public List<Product> popuList() {
		return boardDao.popuList();
	}

	@Override
	public List<Product> interList(String inter) {
		return boardDao.interList(inter);
	}

}
