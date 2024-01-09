package DummyFile;									
import java.util.Scanner;	
//コメントアウトの先頭に[memo:]と記載がある部分は変更点ではなく自分用のメモ
									
public class DummyFile {									
	public static void main(String[] args) {								
									
		try(Scanner scan = new Scanner(System.in)){								
			System.out.println("作成するファイルの100MB以下のバイト数(104857600)を入力してください。");							
			String str = scan.nextLine();								//memo:数値入力
										
			InputCheck ic = new InputCheck(str);							
			if(ic.isNumeric()) { 										//memo : 数字であるかチェック						
				if(ic.checkSize()) {									//memo:9桁以内かつ100MB以下だったらtrueを返すメソッド							
					int fileSize = Math.abs(Integer.parseInt(str));		//memo:入力値を絶対値にする				
					if(CreateFile.createDummyFile(fileSize)) {			//memo:ファイルが作成できたら				
						String outPutFileSize = "";				
						if(fileSize >= (1024*1024)) {				
							outPutFileSize = fileSize/(1024*1024) + "MB";			
						} else if(fileSize >= 1024) {				
							outPutFileSize = fileSize/1024 + "KB";			
						} else {				
							outPutFileSize = fileSize + "B";			
						}	
						System.out.println(outPutFileSize + "のファイルを出力しました。");				
					}else {					
						System.out.println("エラー：ファイル作成に失敗しました。");				
					}	
					
				} else {												 //memo:checkSizeがfalseだったら						
					System.out.println("エラー：100MB以下のバイト数(104857600)を指定してください。");					
				}			
			} else {													//memo:Numericがfalseだったら
				System.out.println("エラー：半角数値のみ入力してください。");	 //「半角」を追記(全角数字をはじくため)	
			}							
		}								
	}								
}									