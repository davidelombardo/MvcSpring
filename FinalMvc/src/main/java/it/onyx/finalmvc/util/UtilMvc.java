package it.onyx.finalmvc.util;

import it.onyx.finalmvc.crud.CrudMvc;
import it.onyx.finalmvc.dao.DaoMvc;

public class UtilMvc {
		public static DaoMvc login ( String email , String password ) {
			
			 
			CrudMvc cc = new CrudMvc();
			
			DaoMvc ud = cc.selectUser(email, password);
			
			return ud;
			
		}
}
