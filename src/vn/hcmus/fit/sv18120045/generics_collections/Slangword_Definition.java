package vn.hcmus.fit.sv18120045.generics_collections;

import java.util.ArrayList;
import java.util.List;

public class Slangword_Definition {
	private String word;
	private List<String> list = new ArrayList<>();
	
	public Slangword_Definition(String word, List<String> definition) {
		super();
		this.word = word;
		this.list = definition;
	}
	
	public String getWord() {
		return word;
	}
	
	public void setWord(String word) {
		this.word = word;
	}
	
	public List<String> getDefinition() {
		return list;
	}
	
	public void setDefinition(List<String> definition) {
		this.list = definition;
	}
	
	@Override
    public String toString() {
        return ("Word: " + word + ", Definition: " + list);
    }
	
	
}
