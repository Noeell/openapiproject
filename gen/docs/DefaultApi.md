# DefaultApi

All URIs are relative to *http://localhost:8080/api/v1/f1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addPony**](DefaultApi.md#addPony) | **POST** /ponies | introduce a new pony to the flock
[**driverGet**](DefaultApi.md#driverGet) | **GET** /driver | List all drivers (funktioniert noch nicht)
[**getPonies**](DefaultApi.md#getPonies) | **GET** /ponies | List all ponies
[**racingteamGet**](DefaultApi.md#racingteamGet) | **GET** /racingteam | List all Racing Teams (funktioniert noch nicht)


<a name="addPony"></a>
# **addPony**
> PonyDto addPony(ponyDto)

introduce a new pony to the flock

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080/api/v1/f1");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    PonyDto ponyDto = new PonyDto(); // PonyDto | 
    try {
      PonyDto result = apiInstance.addPony(ponyDto);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#addPony");
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
 **ponyDto** | [**PonyDto**](PonyDto.md)|  |

### Return type

[**PonyDto**](PonyDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**201** | added the pony |  -  |

<a name="driverGet"></a>
# **driverGet**
> List&lt;DriverDto&gt; driverGet(limit)

List all drivers (funktioniert noch nicht)

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080/api/v1/f1");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer limit = 56; // Integer | How many items to return at one time
    try {
      List<DriverDto> result = apiInstance.driverGet(limit);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#driverGet");
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
 **limit** | **Integer**| How many items to return at one time | [optional]

### Return type

[**List&lt;DriverDto&gt;**](DriverDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | An paged array of drivers |  -  |

<a name="getPonies"></a>
# **getPonies**
> List&lt;PonyDto&gt; getPonies(limit)

List all ponies

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080/api/v1/f1");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer limit = 56; // Integer | How many items to return at one time
    try {
      List<PonyDto> result = apiInstance.getPonies(limit);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#getPonies");
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
 **limit** | **Integer**| How many items to return at one time | [optional]

### Return type

[**List&lt;PonyDto&gt;**](PonyDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | An paged array of pets |  -  |

<a name="racingteamGet"></a>
# **racingteamGet**
> List&lt;RacingTeamDto&gt; racingteamGet(limit)

List all Racing Teams (funktioniert noch nicht)

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080/api/v1/f1");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer limit = 56; // Integer | How many items to return at one time
    try {
      List<RacingTeamDto> result = apiInstance.racingteamGet(limit);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#racingteamGet");
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
 **limit** | **Integer**| How many items to return at one time | [optional]

### Return type

[**List&lt;RacingTeamDto&gt;**](RacingTeamDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | An paged array of Racing Teams |  -  |

