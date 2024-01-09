package DummyFile;				
				
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;	
// java.io.RandomAccessFile;をimport
				
class CreateFile {				
				
	protected static boolean createDummyFile(int byteSize) { //memo:ファイルのサイズを受け取る			
		File file = new File("./DummyFile.txt"); //拡張子(.txt)を記述		
		file.delete(); //memo:既にこの名前のファイルがあったら削除
		
		try {
		 if (file.createNewFile()){ //ファイルを作成するcreateNewFile()を追加
			 	try(RandomAccessFile rFile = new RandomAccessFile(file.getPath(), "rw")){ //memo:rw 読み書きモード	
					rFile.setLength(byteSize); //memo:ファイルを指定した長さにする
					rFile.close(); //memo:ファイルを閉じる
					System.out.println("ファイル作成成功");
				} catch (IOException e) {
					e.printStackTrace();	
					return false;	
				}
	           
	        }else{
	            System.out.println("ファイル作成失敗");
	        }
		} catch (IOException e) {
			e.printStackTrace();	
			return false;	
		}
		
		
		
		return true; //mome:ファイルが作成できたら		
	}			
}				
				
