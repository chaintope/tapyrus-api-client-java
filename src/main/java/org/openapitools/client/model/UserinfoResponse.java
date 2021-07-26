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


package org.openapitools.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.client.model.UserinfoResponseBalances;

/**
 * UserinfoResponse
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2021-07-26T00:10:25.662128Z[Etc/UTC]")
public class UserinfoResponse {
  public static final String SERIALIZED_NAME_SUB = "sub";
  @SerializedName(SERIALIZED_NAME_SUB)
  private Integer sub;

  public static final String SERIALIZED_NAME_BALANCES = "balances";
  @SerializedName(SERIALIZED_NAME_BALANCES)
  private UserinfoResponseBalances balances;

  public static final String SERIALIZED_NAME_ADDRESSES = "addresses";
  @SerializedName(SERIALIZED_NAME_ADDRESSES)
  private List<String> addresses = null;


  public UserinfoResponse sub(Integer sub) {
    
    this.sub = sub;
    return this;
  }

   /**
   * Get sub
   * @return sub
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "1", value = "")

  public Integer getSub() {
    return sub;
  }


  public void setSub(Integer sub) {
    this.sub = sub;
  }


  public UserinfoResponse balances(UserinfoResponseBalances balances) {
    
    this.balances = balances;
    return this;
  }

   /**
   * Get balances
   * @return balances
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public UserinfoResponseBalances getBalances() {
    return balances;
  }


  public void setBalances(UserinfoResponseBalances balances) {
    this.balances = balances;
  }


  public UserinfoResponse addresses(List<String> addresses) {
    
    this.addresses = addresses;
    return this;
  }

  public UserinfoResponse addAddressesItem(String addressesItem) {
    if (this.addresses == null) {
      this.addresses = new ArrayList<String>();
    }
    this.addresses.add(addressesItem);
    return this;
  }

   /**
   * Get addresses
   * @return addresses
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<String> getAddresses() {
    return addresses;
  }


  public void setAddresses(List<String> addresses) {
    this.addresses = addresses;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserinfoResponse userinfoResponse = (UserinfoResponse) o;
    return Objects.equals(this.sub, userinfoResponse.sub) &&
        Objects.equals(this.balances, userinfoResponse.balances) &&
        Objects.equals(this.addresses, userinfoResponse.addresses);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sub, balances, addresses);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserinfoResponse {\n");
    sb.append("    sub: ").append(toIndentedString(sub)).append("\n");
    sb.append("    balances: ").append(toIndentedString(balances)).append("\n");
    sb.append("    addresses: ").append(toIndentedString(addresses)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

