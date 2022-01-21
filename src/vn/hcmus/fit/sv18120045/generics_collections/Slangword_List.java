package vn.hcmus.fit.sv18120045.generics_collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


class Slangword_List {
	private Scanner sc= new Scanner(System.in);
    private String InputFile = "slang.txt";
    private List<Slangword_Definition> SWD_List = new ArrayList<>();
    
    
    public Slangword_List() {
        DocFile file = new DocFile();
        file.ReadFile(InputFile, SWD_List);
    }
    
    private String InputSlangWord()
    {
        System.out.print("Input slang word: ");
        return sc.nextLine();
    }
    
    private String InputDefinition()
    {
        System.out.print("Input definition: ");
        return sc.nextLine();
    }
    
    public void Show_SlangWordList() {
    	for (int i=0; i<SWD_List.size(); i++) {    	  
            Slangword_Definition SWD = SWD_List.get(i);
            System.out.println(SWD.toString());
        }
    }
    
    public boolean Search_SlangWord(String Word, List<String> definitionList) {
    	for (int i=0; i<SWD_List.size(); i++) {        	
        	Slangword_Definition SWD = SWD_List.get(i);
        	if (SWD.getWord().equals(Word) == true) {
        		for (int j=0; j<SWD.getDefinition().size(); j++) {
        			String string = SWD.getDefinition().get(j);
        			definitionList.add(string);
        		}
        	}
        }        
        return (!(definitionList.isEmpty()));
    }
    
    public boolean Search_Definition(String definition, List<String> wordList) {
    	for (int i=0; i<SWD_List.size(); i++) {
    		Slangword_Definition SWD = SWD_List.get(i);
    		for (int j=0; j<SWD.getDefinition().size(); j++) {
    			String string = SWD.getDefinition().get(j);
    			if (string.equalsIgnoreCase(definition) == true) {
    				wordList.add(SWD.getWord());
    				break;
    			}
    		}
    	}
    	return (!wordList.isEmpty());
    }
    
    public void Add(String Word) {
    	List<String> definitionList = new ArrayList<>();
    	String definition = "";
		System.out.println("Input END to finish.");
		while (true) {
			definition = InputDefinition();
			if (definition.equals("END") == true)
				break;
			definitionList.add(definition);
		}
		Slangword_Definition newSWD = new Slangword_Definition(Word, definitionList);		
		List<String> defList = new ArrayList<>();
    	if (Search_SlangWord(Word, defList) == true) {
    		System.out.print("Slang Word is duplicated. You have 2 selections:\n1. Overwrite\n2. Duplicate\nYour choice: ");
    		int choice = sc.nextInt();
    		while (choice != 1 && choice != 2) {
    			System.out.print("Your choice: ");
    			choice = sc.nextInt();
    		}
    		if (choice == 1) {
    			for (int i=0; i<SWD_List.size(); i++) {
    				if (SWD_List.get(i).getWord().equals(Word) == true)
    					SWD_List.get(i).setDefinition(definitionList);
    			}
    		}
    		else {
    			for (int i=0; i<SWD_List.size(); i++) {
    				if (SWD_List.get(i).getWord().equals(Word) == true) {
    					for (int j=0; j<SWD_List.get(i).getDefinition().size(); j++) {
    						definitionList.add(SWD_List.get(i).getDefinition().get(j));
    					}
    					SWD_List.get(i).setDefinition(definitionList);
    				}
    			}
    		}
    	}
    	else
    	{
    		SWD_List.add(newSWD);
    	}
    }
    
    public void Edit (String Word) {
    	List <String> definition =  new ArrayList<>();
	    if (Search_SlangWord(Word, definition) == true) {
		   	System.out.print("1. Edit word\n2. Edit definition\n");
		   	System.out.print("Your choice: ");
		   	int choice = sc.nextInt();
			while (choice != 1 && choice != 2) {
				System.out.print("Your choice: ");
				choice = sc.nextInt();
			}
			if (choice == 1) {
		   		String word = InputSlangWord();
		   		for (int i=0; i<SWD_List.size(); i++)
    			{
    				if (SWD_List.get(i).getWord().equals(Word) == true)
    					SWD_List.get(i).setWord(word);
    			}		   		
			}
		   	else {
		   		List<String> definitionList = new ArrayList<>();
		   		String def = "";
		   		System.out.println("Input END to finish.");
		   		while (true) {
					def = InputDefinition();
					if (def.equals("END") == true)
						break;
					definitionList.add(def);
				}
		   		for (int i=0; i<SWD_List.size(); i++)
    			{
    				if (SWD_List.get(i).getWord().equals(Word) == true)
    					SWD_List.get(i).setDefinition(definitionList);
    			}
		   	}
	    }
    }
    
    public void Delete (String Word) {
    	List <String> definition =  new ArrayList<>();
	    if (Search_SlangWord(Word, definition) == true) {
    		System.out.print("Do you want to delete?\n1. Yes\n2. No\nYour choice: ");
    		int choice = sc.nextInt();
    		while (choice != 1 && choice != 2) {
    			System.out.print("Your choice: ");
        		choice = sc.nextInt();
    		}
    		if (choice == 1) {
    			for (int i=0; i<SWD_List.size(); i++)
    			{
    				if (SWD_List.get(i).getWord().equals(Word) == true)
    					SWD_List.remove(i);
    			}
        		System.out.println("Deleted successfully");
    		}
    		else {
    			System.out.println("Do not delete");
    			return;
    		}
    		
    	}
    	else {
    		System.out.println("Word " + " does not exist");
    	}
    }
    
    public void Reset() {
    	SWD_List.clear();
    	DocFile file = new DocFile();
        file.ReadFile(InputFile, SWD_List);
    }
    
    public Slangword_Definition On_this_day_SlangWord() {
    	Random rand = new Random();
    	int ranNum = rand.nextInt(SWD_List.size());
    	return SWD_List.get(ranNum);
    }
    
    public void Quiz() {
    	Slangword_Definition Word0 = On_this_day_SlangWord();
    	Slangword_Definition Word1 = On_this_day_SlangWord();
    	while (Word1.getWord().equals(Word0.getWord()) == true) {
    		Word1 = On_this_day_SlangWord();
    	}
    	Slangword_Definition Word2 = On_this_day_SlangWord();
    	while (Word2.getWord().equals(Word1.getWord())==true || Word2.getWord().equals(Word0.getWord())==true) {
    		Word2 = On_this_day_SlangWord();
    	}
    	Slangword_Definition Word3 = On_this_day_SlangWord();
    	while (Word3.getWord().equals(Word2.getWord())==true ||Word3.getWord().equals(Word1.getWord())==true || Word3.getWord().equals(Word0.getWord())==true) {
    		Word3 = On_this_day_SlangWord();
    	}
    	System.out.print("1. Guess definition.\n2. Guess slang word\nYour choice: "); 
    	int choice = sc.nextInt();
    	while (choice != 1 && choice != 2) {
    		System.out.print("Your choice: ");
        	choice = sc.nextInt();
    	}
    	List<Slangword_Definition> Array = new ArrayList<>();
    	Array.add(Word0);
    	Array.add(Word1);
    	Array.add(Word2);
    	Array.add(Word3);
    	if (choice == 1) 
    		Guess_Definition(Array);
    	else
    		Guess_SlangWord(Array);
    }
    
    public void Guess_Definition(List<Slangword_Definition> Array) {
    	Slangword_Definition SlangWord = Array.get(0);
    	System.out.println("Word: " + SlangWord.getWord());  	
    	Collections.shuffle(Array);
    	for (int i=0; i<Array.size(); i++) {
    		System.out.println(i+1 + ". " + Array.get(i).getDefinition());
    	}
    	System.out.print("Your choice: ");
    	int choice = sc.nextInt();
    	while (choice != 1 && choice != 2 && choice != 3 && choice != 4) {
    		System.out.print("Your choice: ");
        	choice = sc.nextInt();
    	}
    	if (Array.get(choice-1).getDefinition().equals(SlangWord.getDefinition()) == true) {
    		System.out.println("TRUE");
    	}
    	else {
    		System.out.println("FALSE");
    	}
    }
    
    public void Guess_SlangWord(List<Slangword_Definition> Array) {
    	Slangword_Definition SlangWord = Array.get(0);
    	System.out.println("Definition: " + SlangWord.getDefinition());  	
    	Collections.shuffle(Array);
    	for (int i=0; i<Array.size(); i++) {
    		System.out.println(i+1 + ". " + Array.get(i).getWord());
    	}
    	System.out.print("Your choice: ");
    	int choice = sc.nextInt();
    	while (choice != 1 && choice != 2 && choice != 3 && choice != 4) {
    		System.out.print("Your choice: ");
        	choice = sc.nextInt();
    	}
    	if (Array.get(choice-1).getWord().equals(SlangWord.getWord()) == true) {
    		System.out.println("TRUE");
    	}
    	else {
    		System.out.println("FALSE");
    	}
    }
}
