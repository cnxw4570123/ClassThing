package day17;
import java.util.ArrayList;
import java.util.Scanner;


public class ProdManager {
	private Scanner sc = new Scanner(System.in);
//	private int num = 0;
	ArrayList<ProductInfo> prodList = new ArrayList<ProductInfo>();
	
	public void showMenu() {
		int subcom, com;
		boolean run = true;
		while(run) {
			System.out.println("================================================================");
			System.out.println(" [1]상품등록 | [2]상품검색 | [3]상품수정 | [4]전체상품목록 | [5]상품삭제 | [6]종료 ");
			System.out.println("================================================================");
			System.out.print("메뉴선택>>");
			com = sc.nextInt();
			switch(com) {
			case 1:
				System.out.println("[상품등록]");
				registProd();
				System.out.println("상품이 등록되었습니다.");
				break;
			case 2:
				System.out.println("[상품검색]");
				System.out.println("=======================");
				System.out.println("[1]상품이름검색 | [2]상품종류검색");
				System.out.println("=======================");
				subcom = sc.nextInt();
				if(subcom == 1) {
					checkProdName();
				} else if(subcom == 2) {
					checkProdType();
				} else {
					System.out.println("취소되었습니다.");
				}
				break;
			case 3:
				System.out.println("[상품수정]");
				System.out.print("수정할 ");
				int idx = SearchIdx();
				if(idx != -1) {
					System.out.println("[검색된 상품 정보]");
					System.out.println(prodList.get(idx).toString());
					System.out.println("===================");
					System.out.println("[1]가격수정 | [2]재고수정");
					System.out.println("===================");
					System.out.print("선택>>");
					subcom = sc.nextInt();
					modifyProd(idx, subcom);
				} else {
					System.out.println("상품을 찾을 수 없습니다.");
				}
				break;
			case 4:
				System.out.println("[전체상품목록]");
				showInfo();
				break;
			case 5:
				System.out.println("[상품삭제]");
				removeProd();
				break;
			case 6:
				System.out.println("[종료]");
				run = false;
				break;
			}
			
		}
	}
	
	public void registProd() {
		ProductInfo prod = new ProductInfo();
		String sName;
		while(true) {
			System.out.print("등록하실 이름>>");
			sName = sc.next();
			int idx = SearchIdx(sName);
			if(idx == -1) {
				break;
			}else {
				System.out.println("이미 있는 이름입니다.");
			}
		}
			prod.setProdName(sName);
			System.out.print("상품가격>>");
			prod.setProdPrice(sc.nextInt());
			System.out.print("상품수량>>");
			prod.setProdVol(sc.nextInt());
			System.out.print("상품종류>>");
			prod.setProdType(sc.next());
			prodList.add(prod);
			prod.setProdNum(prodList.size());
	}
	
	
	public void checkProdName() {
		int idx = SearchIdx();
		if(idx == -1) {
			System.out.println("상품을 찾을 수 없습니다.");
		} else {
			System.out.println(prodList.get(idx).toString());
		}
	}
	
	
	
	public int SearchIdx() {
		int idx = -1;
		System.out.print("상품명을 입력해주세요>>");
		String name = sc.next();
		for(int i = 0; i < prodList.size(); i++) {
			if(name.equals(prodList.get(i).getProdName()))
				idx = i;
		}
		return idx;
	}
	public int SearchIdx(String name) {
		int idx = -1;
		for(int i = 0; i < prodList.size(); i++) {
			if(name.equals(prodList.get(i).getProdName()))
				idx = i;
		}
		return idx;
	}
	
//	public void checkProdType() {
//		int idx = -1;
//		System.out.print("검색할 상품종류 입력>>");
//		String searcType = sc.next();
//		for(int i = 0; i < prodList.size(); i++) {
//			if(searcType.equals(prodList.get(i).getProdType())) {
//				idx = i;
//				break;
//			}
//		}
//		if(idx != -1) {
//			System.out.println("["+prodList.get(idx).getProdType()+"]종류로 검색된 상품");
//			for(int i = 0; i < prodList.size(); i++) {
//				if(searcType.equals(prodList.get(i).getProdType())) {
//					System.out.print("[상품이름]"+prodList.get(i));
//					System.out.println();
//				}
//			}
//		} else {
//			System.out.println("상품을 찾을 수 없습니다.");
//		}
//	}
	public void checkProdType() {
		ArrayList<Integer> searchList = new ArrayList<Integer>();
		int idx = -1;
		System.out.print("검색할 상품종류 입력>>");
		String searcType = sc.next();
		for(int i = 0; i < prodList.size(); i++) {
			if(searcType.equals(prodList.get(i).getProdType())) {
				idx = i;
				searchList.add(idx);
			}
		}
		if(searchList.size() > 0) {
			System.out.println("[" + searcType + "] 종류로 검색되는 상품은 " + searchList.size() + "개이며");
			for(int i = 0; i < searchList.size(); i++) {
				System.out.println(prodList.get(searchList.get(i)));
			}
			System.out.println("입니다.");
		} else {
			System.out.println("[" + searcType + "] 종류로 검색되는 상품이 없습니다.");
		}
	}
	
	public void modifyProd(int idx, int com) {
		int modify;
		ProductInfo search = prodList.get(idx);
		if(com == 1) {
			int befMp = search.getProdPrice();
			System.out.print("변경할 가격 입력>>");
			modify = sc.nextInt();
			if(modify <= 0)
				modify = 0;
			search.setProdPrice(modify);
			System.out.println("상품의 재고가 변경(" + befMp + ">>" 
			+ search.getProdPrice() + ") 되었습니다.");
		} else if(com == 2) {
			int befMv = search.getProdVol();
			System.out.print("변경할 재고 입력>>");
			modify = sc.nextInt();
			if(modify <= 0)
				modify = 0;
			search.setProdVol(modify);
			System.out.println("상품의 재고가 변경(" + befMv + ">>" 
			+ search.getProdVol() + ") 되었습니다.");
			
		} else {
			System.out.println("취소되었습니다.");
		}
	}
	
	public void removeProd() {
		int idx = SearchIdx();
		if(idx != -1) {
			ProductInfo rmProd = prodList.get(idx);
			System.out.println(rmProd + "\n해당 상품을 삭제하시겠습니까([1]삭제 | [2]취소)");
			int com = sc.nextInt();
			if(com == 1) {
				prodList.remove(idx);
				System.out.println("해당 상품이 삭제되었습니다.");
			} else {
				System.out.println("취소되었습니다.");
			}
		}else {
			System.out.println("등록된 상품이 없습니다.");
		}
	}
	
	public void showInfo() {
		for(int i = 0; i <prodList.size(); i++) {
			System.out.println(prodList.get(i));
		}
	}
}
