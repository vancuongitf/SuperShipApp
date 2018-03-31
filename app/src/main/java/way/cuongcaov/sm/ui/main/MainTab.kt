package way.cuongcaov.sm.ui.main

import android.support.annotation.DrawableRes
import android.support.v4.app.Fragment
import way.cuongcaov.sm.R
import way.cuongcaov.sm.ui.account.AccountFragment
import way.cuongcaov.sm.ui.bill.BillFragment
import way.cuongcaov.sm.ui.home.HomeContainer

/**
 * MainTab
 * @author cuongcaov
 */
class MainTab(val itemType: TabItemType) {

    private val homeContainer = HomeContainer()
    private val billFragment = BillFragment()
    private val accountFragment = AccountFragment()

    /**
     * TabItemType
     */
    enum class TabItemType(@DrawableRes val icon: Int, @DrawableRes val iconRed: Int, var isSelected: Boolean = false) {
        /**
         * First Item On Tab
         */
        ITEM_HOME(R.drawable.ic_home, R.drawable.ic_home_red, true),

        /**
         * Second Item On Tab
         */
        ITEM_BILL(R.drawable.ic_bill, R.drawable.ic_bill_red),

        /**
         * Third Item On Tab
         */
        ITEM_ACCOUNT(R.drawable.ic_account, R.drawable.ic_account_red)
    }

    /**
     * Method return item of tab each position
     */
    fun getItem(): Fragment = when (itemType) {
        TabItemType.ITEM_HOME -> homeContainer
        TabItemType.ITEM_BILL -> billFragment
        TabItemType.ITEM_ACCOUNT -> accountFragment
    }
}
