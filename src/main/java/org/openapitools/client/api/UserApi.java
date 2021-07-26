/*
 * Tapyrus API
 * # イントロダクション  これは chaintope 社が開発するブロックチェーン Tapyrus を使ったブロックチェーンに関係する機能を簡単に利用するための REST API です。 現在以下のユースケースをサポートしています。これは今後も拡張されていくことを予定しています。 * Payment: TPC(Tapyrus Coin) の送金 * Timestamp: 任意のデータをタイムスタンプとしてブロックチェーンに記録 * Token: 新しいトークンの発行、送金、焼却。NFTも利用可能  Tapyrus ブロックチェーンについては以下の情報を参照してください。  * [Chaintope のブロックチェーンプロトコル](https://www.chaintope.com/chaintope-blockchain-protocol/) * [chaintope/tapyrus-core - github](https://github.com/chaintope/tapyrus-core)  ## Tapyrus API の利用法  Tapyrus API は REST API として提供されています。利用を開始するためには、Tapyrus API の `エンドポイント` に対して、 `認証` 済みの トークンを使いアクセスする必要があります。また、認証されたユーザはそれぞれが自身のウォレットを Tapyrus API 内部に持つことになります。 ウォレットではそのユーザの TPC やトークンといったアセットを管理するための鍵が管理され、アセットの移動などで利用されます。  ### Tapyrus API のエンドポイント  エンドポイントは以下のフォーマットで作成され、 chaintope より提供されます。  `ap-01.tapyrus.chaintope.com`  例えば [testnet](https://testnet-explorer.tapyrus.dev.chaintope.com/blocks) では以下のようになります。  `testnet-api.tapyrus.chaintope.com`  testnet は誰でも利用可能な動作の確認用のネットワークであり、予告なくリセットされる可能性があります。 利用に必要な TPC は [faucet](https://testnet-faucet.tapyrus.dev.chaintope.com) から取得できます。  * [faucet](https://testnet-faucet.tapyrus.dev.chaintope.com)  ### OpenID Connect を使った認証  Tapyrus API では [OpenID Connect](https://openid.net/connect/) を使った認証をサポートします。この認証を利用するためには、 以下のステップを踏みます。  1. 利用する OpenID Provider(OP) を選択する    公開された OP から選択する方法と、自身で OP を構築する方法があります。独自のユーザデータベースがあり、そのユーザに Tapyrus API   を利用させる場合は後者の自身で OP を構築する方法を選択することになります。  2. OAuth 2.0 Client Credential を入手する    多くの公開された OP では、アプリケーションを登録して Client Credential を入手する必要があります。手順は利用する OP に従ってください。  3. Access Token と ID Token を入手する    OpenID Connect に沿った認証を行い、 token エンドポイントから ID Token を入手します。  4. Tapyrus API ユーザを作成する    入手した Access Token と ID Token を Tapyrus API の [createUser API](https://doc.api.tapyrus.chaintope.com/#operation/createUser) へ送り、 Tapyrus API のユーザを作成します。  コード例を後述の Getting Started ドキュメントで解説していますので、そちらを参照してください。  ## Tapyrus API ユーザとウォレットについて  認証により得たアクセストークンを使い、Tapyrus API ユーザを１つ作成する必要があります。 Tapyrus API の内部では、このユーザ１つにつき１つのウォレットが作成されます。 ウォレットではアセットの受け取りや、送付に必要な公開鍵と秘密鍵のペアが管理されており、同時にそれらのカギに紐づくアセットも管理されます。 そのため、認証を行ったユーザごとに独立したアセットの管理が可能になります。  # Getting Started  Getting Started ドキュメントでは実際のコード例を交えながらより具体的な Tapyrus API の利用法を解説しています。    * [Getting Started - [Javascript] Tapyrus API を利用するウェブアプリケーションの開発を学ぶ](https://github.com/chaintope/tapyrus-api-client-examples/tree/main/javascript/GettingStarted-ja.md) 
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.openapitools.client.api;

import org.openapitools.client.ApiCallback;
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.ApiResponse;
import org.openapitools.client.Configuration;
import org.openapitools.client.Pair;
import org.openapitools.client.ProgressRequestBody;
import org.openapitools.client.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import org.openapitools.client.model.CreateUserRequest;
import org.openapitools.client.model.UserinfoResponse;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserApi {
    private ApiClient localVarApiClient;

    public UserApi() {
        this(Configuration.getDefaultApiClient());
    }

    public UserApi(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return localVarApiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    /**
     * Build call for createUser
     * @param createUserRequest  (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> Unprocessable Entity </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal Server Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call createUserCall(CreateUserRequest createUserRequest, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = createUserRequest;

        // create path and map variables
        String localVarPath = "/users";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] {  };
        return localVarApiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call createUserValidateBeforeCall(CreateUserRequest createUserRequest, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'createUserRequest' is set
        if (createUserRequest == null) {
            throw new ApiException("Missing the required parameter 'createUserRequest' when calling createUser(Async)");
        }
        

        okhttp3.Call localVarCall = createUserCall(createUserRequest, _callback);
        return localVarCall;

    }

    /**
     * ユーザを作成します。
     * OpenID Connect を使った認証で得た id_token と access_token を Tapyrus API へ登録しユーザを作成します。すでにユーザが存在する場合は認証情報を更新します。
     * @param createUserRequest  (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> Unprocessable Entity </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal Server Error </td><td>  -  </td></tr>
     </table>
     */
    public void createUser(CreateUserRequest createUserRequest) throws ApiException {
        createUserWithHttpInfo(createUserRequest);
    }

    /**
     * ユーザを作成します。
     * OpenID Connect を使った認証で得た id_token と access_token を Tapyrus API へ登録しユーザを作成します。すでにユーザが存在する場合は認証情報を更新します。
     * @param createUserRequest  (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> Unprocessable Entity </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal Server Error </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<Void> createUserWithHttpInfo(CreateUserRequest createUserRequest) throws ApiException {
        okhttp3.Call localVarCall = createUserValidateBeforeCall(createUserRequest, null);
        return localVarApiClient.execute(localVarCall);
    }

    /**
     * ユーザを作成します。 (asynchronously)
     * OpenID Connect を使った認証で得た id_token と access_token を Tapyrus API へ登録しユーザを作成します。すでにユーザが存在する場合は認証情報を更新します。
     * @param createUserRequest  (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> Unprocessable Entity </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal Server Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call createUserAsync(CreateUserRequest createUserRequest, final ApiCallback<Void> _callback) throws ApiException {

        okhttp3.Call localVarCall = createUserValidateBeforeCall(createUserRequest, _callback);
        localVarApiClient.executeAsync(localVarCall, _callback);
        return localVarCall;
    }
    /**
     * Build call for getUserInfo
     * @param confirmationOnly オプションで&#x60;confirmation_only&#x60;を設定でき、&#x60;true&#x60;の場合ブロックチェーン上で承認済みのtpc・トークンのみを取得し、&#x60;false&#x60;の場合未承認のtpc・トークンも含めて取得します。デフォルトは&#x60;true&#x60;です。 (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Success </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> Unprocessable Entity </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal Server Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getUserInfoCall(Boolean confirmationOnly, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/userinfo";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (confirmationOnly != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("confirmation_only", confirmationOnly));
        }

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] {  };
        return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call getUserInfoValidateBeforeCall(Boolean confirmationOnly, final ApiCallback _callback) throws ApiException {
        

        okhttp3.Call localVarCall = getUserInfoCall(confirmationOnly, _callback);
        return localVarCall;

    }

    /**
     * ユーザの情報を返します。
     * ユーザの&#x60;id&#x60;,&#x60;balance&#x60;, &#x60;address&#x60;の情報を返します。
     * @param confirmationOnly オプションで&#x60;confirmation_only&#x60;を設定でき、&#x60;true&#x60;の場合ブロックチェーン上で承認済みのtpc・トークンのみを取得し、&#x60;false&#x60;の場合未承認のtpc・トークンも含めて取得します。デフォルトは&#x60;true&#x60;です。 (optional)
     * @return UserinfoResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Success </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> Unprocessable Entity </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal Server Error </td><td>  -  </td></tr>
     </table>
     */
    public UserinfoResponse getUserInfo(Boolean confirmationOnly) throws ApiException {
        ApiResponse<UserinfoResponse> localVarResp = getUserInfoWithHttpInfo(confirmationOnly);
        return localVarResp.getData();
    }

    /**
     * ユーザの情報を返します。
     * ユーザの&#x60;id&#x60;,&#x60;balance&#x60;, &#x60;address&#x60;の情報を返します。
     * @param confirmationOnly オプションで&#x60;confirmation_only&#x60;を設定でき、&#x60;true&#x60;の場合ブロックチェーン上で承認済みのtpc・トークンのみを取得し、&#x60;false&#x60;の場合未承認のtpc・トークンも含めて取得します。デフォルトは&#x60;true&#x60;です。 (optional)
     * @return ApiResponse&lt;UserinfoResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Success </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> Unprocessable Entity </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal Server Error </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<UserinfoResponse> getUserInfoWithHttpInfo(Boolean confirmationOnly) throws ApiException {
        okhttp3.Call localVarCall = getUserInfoValidateBeforeCall(confirmationOnly, null);
        Type localVarReturnType = new TypeToken<UserinfoResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * ユーザの情報を返します。 (asynchronously)
     * ユーザの&#x60;id&#x60;,&#x60;balance&#x60;, &#x60;address&#x60;の情報を返します。
     * @param confirmationOnly オプションで&#x60;confirmation_only&#x60;を設定でき、&#x60;true&#x60;の場合ブロックチェーン上で承認済みのtpc・トークンのみを取得し、&#x60;false&#x60;の場合未承認のtpc・トークンも含めて取得します。デフォルトは&#x60;true&#x60;です。 (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Success </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> Unprocessable Entity </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal Server Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getUserInfoAsync(Boolean confirmationOnly, final ApiCallback<UserinfoResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = getUserInfoValidateBeforeCall(confirmationOnly, _callback);
        Type localVarReturnType = new TypeToken<UserinfoResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
}
