package vn.hcmus.fit.sv18120045.generics_collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
	private Scanner sc= new Scanner(System.in);
	public void WriteMenu() {
        System.out.println("-------------------- MENU --------------------");
        System.out.println("1. Search Slang word");
        System.out.println("2. Search Definition");
        System.out.println("3. Show History");
        System.out.println("4. Add 1 Slang word");
	    System.out.println("5. Edit 1 Slang word");
        System.out.println("6. Delete 1 Slang word");
        System.out.println("7. Reset Slang word list");
        System.out.println("8. On this day Slang word");
        System.out.println("9. Quiz");
        System.out.println("0. Exit");
        System.out.println("----------------------------------------------");
        System.out.print("Your choice: ");
    }
    public Menu() {
        boolean exit = false, test = false;
        Slangword_List SW_List = new Slangword_List();
        HistoryList HisList = new HistoryList();
        String word = "";
        String definition = "";
        while (true)
        {
            if (exit == true) {
                System.out.println("EXIT");
                break;
            }
            WriteMenu();
            int choice = sc.nextInt();
            switch(choice) {
            case 1:
            	System.out.print("Input Slang word: ");
            	sc.nextLine();
            	word = sc.nextLine();
            	List <String> definitionList = new ArrayList<>();
            	test = SW_List.Search_SlangWord(word, definitionList);
            	if (test == true) {
            		System.out.print("Word " + word + " has definitions: ");
            		for (int i=0; i<definitionList.size(); i++)
            			System.out.print(definitionList.get(i) + " ");
            		System.out.print("\n");
            	}
            	else {
            		System.out.println("Slang word: " + word + " does not exist.");
            	}
            	Slangword_Definition SWD = new Slangword_Definition(word, definitionList);
            	HisList.Add(SWD);
            	definitionList.clear();
            	break;
            case 2:
            	System.out.print("Input definition: ");
            	sc.nextLine();
            	definition = sc.nextLine();
            	List <String> wordList = new ArrayList<>();
            	test = SW_List.Search_Definition(definition, wordList);
            	if (test == true) {
            		System.out.print("Definition " + definition + " has words: ");
            		for (int i=0; i<wordList.size(); i++)
            			System.out.print(wordList.get(i) + " ");
            		System.out.print("\n");
            	}
            	else {
            		System.out.println("Definition: " + definition + " does not exist.");
            	}
            	Slangword_Definition SWD1 = new Slangword_Definition(definition, wordList); 
            	HisList.Add(SWD1);
            	wordList.clear();
            	break;
            case 3:
            	System.out.println("-----HISTORY-----");
            	HisList.ShowHistory();
            	break;
            case 4:
            	System.out.print("Input Slang word: ");
            	sc.nextLine();
            	word = sc.nextLine();
            	SW_List.Add(word);
            	break;
            case 5:
            	System.out.print("Input Slang word: ");
            	sc.nextLine();
            	word = sc.nextLine();
            	SW_List.Edit(word);
            	break;
            case 6:
            	System.out.print("Input Slang word: ");
            	sc.nextLine();
            	word = sc.nextLine();
            	SW_List.Delete(word);
            	break;
            case 7:
            	SW_List.Reset();
            	break;
            case 8:
            	SWD = SW_List.On_this_day_SlangWord();
            	System.out.println(SWD.toString());
            	break;
            case 9:
            	SW_List.Quiz();
            	break;
            case 0:
                exit = true;
                break;
            default:
                System.out.println("Wrong number. Please choose agian.");
                break;
            }
        }
    }
}
