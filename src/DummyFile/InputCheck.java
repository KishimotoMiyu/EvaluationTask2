package DummyFile;					
//コメントアウトの先頭に[memo:]と記載がある部分は変更点ではなく自分用のメモ

class InputCheck {					
					
	private String str;				
					
	public InputCheck(String str) {			
		if(str == null) {			
			str = "";		
		}			
		this.str = str;										//this.を付け加えた
	}				
					
	protected boolean isNumeric() {							//memo : 数字であるかチェック
		
		boolean num = true; 								//戻り値を変数で管理
		
		if (this.str == "" ) { 								//memo:空文字ならfalse			
			return num;			
		} else {		
			for (int i = 0; i < this.str.length(); i++){	//memo:文字数				
				char c = this.str.charAt(i);
				if (c < '0' || c > '9' || c == '-' ){		//if文を変更の条件を変更
					num = false;							//数字じゃなかったらfalse
					break;									//1文字でも半角数字ではない値が入ればその時点でbreak
				}else {
					num = true;
				}
			}
		}
		return num;	
		
	}					
					
	protected boolean checkSize() {										//memo:9桁以内かつ100MB以下だったらtrueを返すメソッド			
		if(this.str.length() < 10) { 									// <= を <　に変更した
			
			if(Math.abs(Integer.parseInt(this.str)) <= 1024*1024*100) {	//memo:strをint型にした時に100MB以下だったら	
				return true;		
			} else { // elseを追加
				return false;
			}
			
		} else {				
			return false;			
		}				
	}					
}					