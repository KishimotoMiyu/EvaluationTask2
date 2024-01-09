package DummyFile;					
					
class InputCheck {					
					
	private String str;				
					
	public InputCheck(String str) {			
		if(str == null) {			
			str = "";		
		}			
		this.str = str;		
		//this.を付け加えた
	}				
					
	protected boolean isNumeric() {	//memo : 数字であるかチェック
		
		boolean num = true; //戻り値を変数で管理
		
		if (this.str == "" ) { //memo:空文字ならfalse			
			return num;			
		} else {		
			for (int i = 0; i < this.str.length(); i++){ //memo:文字数				
				char c = this.str.charAt(i); //memo:文字列[i]番目をchar型へ
				System.out.println(c);
				if (c < '0' || c > '9' || c == '-' ){ //if文を変更の条件を変更
					num = false; //数字じゃなかったらfalse
					break;
				}else {
					num = true;
				}
			}
		}
		return num;	
		
	}					
					
	protected boolean checkSize() {	//memo:9桁以内かつ100MB以下だったらtrueを返すメソッド			
		if(this.str.length() < 10) { // <= を <　に変更した
			
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