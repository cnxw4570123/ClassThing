package jsouptest;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import dao.ProductDao;
import dto.ProductDto;

public class Jsouptest {
	public static void main(String[] args) {
		String url = "https://www.oliveyoung.co.kr/store/main/getBestList.do";
		ProductDao pDao = new ProductDao();
		ProductDto prd = null;
		int result = 0;
		try {
			Document doc = Jsoup.connect(url).get();
			Elements bestDiv = doc.select("#Container > div.best-area > div.TabsConts.on");
			Elements productList = bestDiv.get(0).select("li");
			String brandName = productList.get(0).select("span.tx_brand").text();

			for (Element product : productList) {
				String prdBrand = product.select("span.tx_brand").text();
				String prdName = product.select("p.tx_name").text();
				int prdPrice = Integer.parseInt(product.select("span.tx_cur > span.tx_num").text().replace(",", ""));
				String PrdImgUrl = product.select("div > a> img").attr("src");
				String prcode ="P" + String.format("%04d", (pDao.selectMaxNum() + 1));

				prd = new ProductDto(prcode,prdBrand,prdName,prdPrice,PrdImgUrl);
				
				result += pDao.insertProduct(prd);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
