# PaymentApi

All URIs are relative to *https://ap-01.tapyrus.chaintope.com/api/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**transfer**](PaymentApi.md#transfer) | **POST** /payment | 資金の送金


<a name="transfer"></a>
# **transfer**
> PaymentResponse transfer(paymentRequest)

資金の送金

指定したアドレスに任意のtapyrusを送金します。

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.PaymentApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://ap-01.tapyrus.chaintope.com/api/v1");
    
    PaymentApi apiInstance = new PaymentApi(defaultClient);
    PaymentRequest paymentRequest = new PaymentRequest(); // PaymentRequest | `address`, `amount`を受け取り、アドレスに対して指定した額の資金(tapyrus)を送金します。 任意で`fee`を設定し、送金手数料を指定できます。 
    try {
      PaymentResponse result = apiInstance.transfer(paymentRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PaymentApi#transfer");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **paymentRequest** | [**PaymentRequest**](PaymentRequest.md)| &#x60;address&#x60;, &#x60;amount&#x60;を受け取り、アドレスに対して指定した額の資金(tapyrus)を送金します。 任意で&#x60;fee&#x60;を設定し、送金手数料を指定できます。  | [optional]

### Return type

[**PaymentResponse**](PaymentResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**201** | Created |  -  |
**400** | Bad Request |  -  |
**500** | Internal Server Error |  -  |

