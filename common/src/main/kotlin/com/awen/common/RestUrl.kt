/*
 *
 *     Copyright 2018 The awen_blue Authors
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */

package com.awen.common

object RestUrl {

    const val SERVER_URL = "http://mall.hnprajna.com:31000"


    private const val APP_MODULE = "/app"
    private const val VERSION = "/v1"
    private const val APP_BASE_URL = APP_MODULE + VERSION


    private const val WEB_MODULE = "/web"
    private const val WEB_BASE_URL = WEB_MODULE + VERSION

    private const val HOME = "$APP_BASE_URL/home"
    private const val HOME_API = "$HOME/**"
    const val defaultHome = "$HOME/defaultHome"


    private const val NOTIFY = "$APP_BASE_URL/notify"
    private const val NOTIFY_API = "$NOTIFY/**"
    const val abcNotify = "$NOTIFY/abcNotify"
    const val alipayNotify = "$NOTIFY/alipayNotify"
    const val wechatPayNotify = "$NOTIFY/wechatPayNotify"
    const val logisticsNotify = "$NOTIFY/logisticsNotify"
    const val testNotify = "$NOTIFY/testNotify"


    private const val PAY_BANK = "$APP_BASE_URL/payBank"
    private const val PAY_BANK_API = "$APP_BASE_URL/**"
    const val getPayBankList = "$PAY_BANK/getPayBankList"
    const val addPayBank = "$PAY_BANK/addPayBank"
    const val updatePayBank = "$PAY_BANK/updatePayBank"
    const val deletePayBank = "$PAY_BANK/deletePayBank"


    private const val USER = "$APP_BASE_URL/user"
    const val USER_LOGIN = "$USER/userLogin"
    const val USER_REGISTER = "$USER/userRegister"
    const val USER_MODIFY_PASSWORD = "$USER/userModifyPassword"
    const val USER_FORGET_PASSWORD = "$USER/userForgetPassword"
    const val USER_INFO = "$USER/userInfo"



    private const val COMMON = "$APP_BASE_URL/common"
    private const val COMMON_API = "$COMMON/**"
    const val sendSms = "$COMMON/sendSms"
    const val checkUpdate = "$COMMON/checkUpdate"



    private const val COMMODITY = "$APP_BASE_URL/commodity"
    private const val COMMODITY_API = "$COMMODITY/**"
    const val getCommodityList = "$COMMODITY/getCommodityList"
    const val getCommodity = "$COMMODITY/getCommodity"
    const val getCommodityByAttr = "$COMMODITY/getCommodityByAttr"


    private const val CART = "$APP_BASE_URL/cart"
    private const val CART_API = "$CART/**"
    const val getCartList = "$CART/getCartList"
    const val addCart = "$CART/addCart"
    const val deleteCart = "$CART/deleteCart"
    const val changeCart = "$CART/changeCart"


    private const val ORDER = "$APP_BASE_URL/order"
    private const val ORDER_API = "$ORDER/**"
    const val getOrderList = "$ORDER/getOrderList"
    const val makeOrder = "$ORDER/makeOrder"
    const val payOrder = "$ORDER/payOrder"
    const val getOrderDetail = "$ORDER/getOrderDetail"
    const val getOrderLogistics = "$ORDER/getOrderLogistics"
    const val deleteOrder = "$ORDER/deleteOrder"
    const val orderLogistics = "$ORDER/orderLogistics"


    //退货
    private const val REFUND = "$APP_BASE_URL/refund"
    private const val REFUND_API = "$REFUND/refund"
    const val refundOrder = "$REFUND/refundOrder"
    const val getRefundList = "$REFUND/getRefundList"
    const val getRefundDetail = "$REFUND/getRefundDetail"



    private const val ADDRESS = "$APP_BASE_URL/address"
    private const val ADDRESS_API = "$ADDRESS/**"
    const val getAddressList = "$ADDRESS/getAddressList"
    const val addAddress = "$ADDRESS/addAddress"
    const val updateAddress = "$ADDRESS/updateAddress"
    const val deleteAddress = "$ADDRESS/deleteAddress"

    //Image
    private const val UPLOAD = "/files"
    private const val UPLOAD_API = "$UPLOAD/**"
    const val baseUpload = "$UPLOAD/"
    const val uploadFile = "$UPLOAD/uploadFile"


    //Message
    private const val MESSAGE = "$APP_BASE_URL/message"
    private const val MESSAGE_API = "$APP_BASE_URL/**"
    const val getTopMessage = "$MESSAGE/getTopMessage"
    const val getMessageByType = "$MESSAGE/getMessageByType"
    const val readMessage = "$MESSAGE/readMessage"
    const val deleteMessage = "$MESSAGE/deleteMessage"
    const val deleteMessageByType = "$MESSAGE/deleteMessageByType"







    /**************************************************************************************/
    /**************                                                   *********************/
    /**************                   ADMIN                           *********************/
    /**************                                                   *********************/
    /**************************************************************************************/

    const val ADMIN = "$WEB_BASE_URL/admin"
    private const val ADMIN_API = "$ADMIN/**"

    //UI界面
    const val ADMIN_UI = "$ADMIN/ui"
    const val adminUI = "$ADMIN_UI/adminUI"

    //商品
    const val ADMIN_COMMODITY = "$ADMIN/commodity"
    const val adminAddCommodity = "$ADMIN_COMMODITY/addCommodity"
    const val adminUpdateCommodity = "$ADMIN_COMMODITY/updateCommodity"
    const val adminGetCommodityList = "$ADMIN_COMMODITY/getCommodityList"
    const val adminGetCommodityDetail = "$ADMIN_COMMODITY/getCommodityDetail"
    const val adminDeleteCommodity = "$ADMIN_COMMODITY/deleteCommodity"
    const val adminOutStockCommodity = "$ADMIN_COMMODITY/outStockCommodity"
    const val adminDisableCommodity = "$ADMIN_COMMODITY/disableCommodity"

    const val ADMIN_SKU = "$ADMIN/sku"
    const val adminAddSku = "$ADMIN_SKU/addSku"
    const val adminUpdateSku = "$ADMIN_SKU/updateSku"
    const val adminGetSkuList = "$ADMIN_SKU/getSkuList"
    const val adminGetSkuDetail = "$ADMIN_SKU/getSkuDetail"

    //商品分类
    const val ADMIN_COMMODITY_CATEGORY = "$ADMIN/commodityCategory"
    const val adminAddCommodityCategory = "$ADMIN_COMMODITY_CATEGORY/addCategory"
    const val adminUpdateCommodityCategory = "$ADMIN_COMMODITY_CATEGORY/updateCategory"
    const val adminGetCommodityCategory = "$ADMIN_COMMODITY_CATEGORY/getCategoryList"


    //品牌
    const val ADMIN_BRAND = "$ADMIN/brand"
    const val adminGetBrandList = "$ADMIN_BRAND/getBrandList"
    const val adminAddBrand = "$ADMIN_BRAND/addBrand"
    const val adminDeleteBrand = "$ADMIN_BRAND/deleteBrand"
    const val adminUpdateBrand = "$ADMIN_BRAND/updateBrand"

    //属性分类
    const val ADMIN_CATEGORY = "$ADMIN/category"
    const val adminGetCategoryList = "$ADMIN_CATEGORY/getCategoryList"
    const val adminAddCategory = "$ADMIN_CATEGORY/addCategory"
    const val adminUpdateCategory = "$ADMIN_CATEGORY/updateCategory"
    const val adminDeleteCategory = "$ADMIN_CATEGORY/deleteCategory"


    //属性key
    const val ADMIN_ATTRKEY = "$ADMIN/attrkey"
    const val adminSearchAttrKey = "$ADMIN_ATTRKEY/getAttrKeyList"
    const val adminAddAttrKey = "$ADMIN_ATTRKEY/addAttrKey"
    const val adminUpdateAttrKey = "$ADMIN_ATTRKEY/updateAttrKey"

    //属性value
    const val ADMIN_ATTRVALUE = "$ADMIN/attrvalue"
    const val adminSearchAttrValue = "$ADMIN_ATTRVALUE/searchAttrValue"
    const val adminAddAttrValue = "$ADMIN_ATTRVALUE/addAttrValue"
    const val adminUpdateAttrValue = "$ADMIN_ATTRVALUE/updateAttrValue"

    //订单
    const val ADMIN_ORDER = "$ADMIN/order"
    const val adminGetOrderList = "$ADMIN_ORDER/getOrderList"
    const val adminUpdateOrderLogistics = "$ADMIN_ORDER/updateOrderLogistics"

    //退货
    const val ADMIN_REFUND = "$ADMIN/refund"
    const val adminGetRefundList = "$ADMIN_REFUND/getRefundList"
    const val adminUpdateRefund = "$ADMIN_REFUND/updateRefund"

    //用户
    const val ADMIN_USER = "$ADMIN/user"
    const val adminGetUserList = "$ADMIN_USER/getUserList"
    const val adminEnableUser = "$ADMIN_USER/enableUser"

    //通知
    const val ADMIN_MESSAGE = "$ADMIN/message"
    const val adminGetMessage = "$ADMIN_MESSAGE/getMessage"
    const val adminCreateMessage = "$ADMIN_MESSAGE/createMessage"
    const val adminDeleteMessage = "$ADMIN_MESSAGE/deleteMessage"


    //轮播图
    const val ADMIN_TOP = "$ADMIN/top"
    const val adminGetTopList = "$ADMIN_TOP/getTopList"
    const val adminUpdateTop = "$ADMIN_TOP/updateTop"
    const val adminDeleteTop = "$ADMIN_TOP/deleteTop"
    const val adminAddTop = "$ADMIN_TOP/addTop"


    //放行第三方通知
    private val PERMIT_API_NOTIFY = arrayOf(
            NOTIFY_API
    )

    //放行app用户
    private val PERMIT_API_VISITOR = arrayOf(
            HOME_API,
            USER_LOGIN, USER_REGISTER, USER_FORGET_PASSWORD,
            COMMON_API,
            COMMODITY_API,
            UPLOAD_API,
            MESSAGE_API,
            "/websocket"
    )

    //放行admin
    private val PERMIT_API_ADMIN = arrayOf(
            ADMIN_API
    )

    //放行url
    val PERMIT_API = PERMIT_API_VISITOR + PERMIT_API_ADMIN + PERMIT_API_NOTIFY

    //APP用户校验url
    val APP_USER_AUTH_API = arrayOf(
            USER_MODIFY_PASSWORD, USER_INFO,
            CART_API,
            ORDER_API,
            REFUND_API,
            ADDRESS_API,
            getPayBankList
    )

}