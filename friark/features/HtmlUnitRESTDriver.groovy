import org.openqa.selenium.WebDriverException
import com.gargoylesoftware.htmlunit.WebRequestSettings
import com.gargoylesoftware.htmlunit.HttpMethod
import java.net.URL

class HtmlUnitRESTDriver extends org.openqa.selenium.htmlunit.HtmlUnitDriver {

   public void post(String url, String body){
      WebRequestSettings requestSettings = new WebRequestSettings
  					   ( new URL(url), HttpMethod.POST )
      requestSettings.setRequestBody(body)
      requestSettings.setAdditionalHeader("Content-Type", "application/xml")
      get(requestSettings)
   }

   public void put(String url, String body){
      WebRequestSettings requestSettings = new WebRequestSettings
   				           (
			 	 	      new URL(url), HttpMethod.PUT)
					      requestSettings.setRequestBody(body)
		 			      requestSettings.setAdditionalHeader("Content-Type", "application/xml")
					      get(requestSettings)
   }

   public void delete(String url){
      WebRequestSettings requestSettings = new WebRequestSettings( new URL(url), HttpMethod.DELETE)
       get(requestSettings)
   }

   protected void get(WebRequestSettings fullUrl) {
      try {
         // A "get" works over the entire page
         webClient.getPage(fullUrl);
      } catch (UnknownHostException e) {
         // This should be fine
      } catch (ConnectException e) {
         // This might be expected
      } catch (Exception e) {
         throw new WebDriverException(e);
      }
   }

   public static void main(String[] args){}
}
