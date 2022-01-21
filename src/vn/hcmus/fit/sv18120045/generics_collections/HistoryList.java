package vn.hcmus.fit.sv18120045.generics_collections;

import java.util.ArrayList;
import java.util.List;

public class HistoryList {
    private List<Slangword_Definition> HistoryList = new ArrayList<>(); 
    
    public void Add(Slangword_Definition SWD) {
    	HistoryList.add(SWD);
    }
    
    public void ClearHistory() {
    	HistoryList.clear();
    }
    
    public void ShowHistory() {
    	for (int i=0; i<HistoryList.size(); i++) {
    		System.out.println("Search: " + HistoryList.get(i).getWord());
    	} 
    }
    
}
