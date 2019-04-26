package tree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import tree.binarytree.Node;

public class secondtree {
	binarytree a=new binarytree();
	int count=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		secondtree q=new secondtree();
		q.start();
	}
	public void start() {
		try {
			Scanner files=new Scanner(new File("shuffled_dict.txt"));
			String w=files.nextLine();
			String word=w.split("\\(")[0];
			word=w.substring(0,word.length()-1);
			String c=w.split("\\)")[0];
			c=w.substring(word.length()+2,c.length());
			String meaning=w.substring(word.length()+3+c.length());
			a.insert(new Node(word,c,meaning));
			count++;
			while(files.hasNextLine()) {
				w=files.nextLine();
				word=w.split("\\(")[0];
				word=w.substring(0,word.length()-1);
				c=w.split("\\)")[0];
				c=w.substring(word.length()+2,c.length());
				meaning=w.substring(word.length()+3+c.length());
				a.insert(new Node(word,c,meaning));
				count++;
			}
			files.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// start부분 txt파일 불러오고 단어 잘라서 구분

		while(true) {
			Scanner kb =new Scanner(System.in);
			String comma=kb.next();
			if(comma.equals("size")) {
				System.out.println(count);
			}
			// size는 이진검색트리에 저장된 단어의 개수 출력
			else if(comma.equals("find"))
			{
				String word=kb.next();
				Node find=a.search(new Node (word,null,null));
				if(find==null)
				{
					System.out.println("Not found");
				}
				else
					System.out.println(find.ex);
			}
			// find는 특정단어 검색시 그 단어의 설명을 출력
			else if(comma.equals("add"))
			{
				System.out.print("word: ");
				String word=kb.next();
				System.out.print("class: ");
				kb.nextLine();
				String c=kb.nextLine();
				System.out.print("meaning: ");
				String meaning=kb.next();
				a.insert(new Node(word,c,meaning));
				count++;
			}
			// add는 새로운 단어와 그 단어에 대한 설명 추가
			else if(comma.equals("delete"))
			{
				String word=kb.next();
				Node find=a.delete(new Node(word,null,null));
				if(find==null)
				{
					System.out.println("Not found");
				}
				else {
					System.out.println("Deleted successfully");
				}
			}
			// delete는 특정단어를 검색해 이진검색트리로부터 삭제
			else if(comma.equals("deleteall"))
			{
				int num=0;
				comma=kb.next();
				try {
					Scanner files=new Scanner(new File(comma));
					String word=files.next();
					Node find=a.delete(new Node(word,null,null));
					num++;
					while(files.hasNext()) {
						word=files.next();
						find=a.delete(new Node(word,null,null));
						num++;
					}
					System.out.println(num+" words were deleted successfully.");
					files.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			// deleteall은 삭제할 단어들이 저장된 파일(shuffled_dict.txt) 열어서 그안에 모든 단어들을 이진검색트리에서 삭제
			
			else if(comma.equals("exit"))
			{
				System.exit(0);
				kb.close();
			}
			// exit는 종료
		}
		
	}

}