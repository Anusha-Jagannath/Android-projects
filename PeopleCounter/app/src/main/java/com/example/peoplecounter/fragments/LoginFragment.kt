package com.example.peoplecounter.fragments

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.peoplecounter.R
import com.example.peoplecounter.presenters.LoginFragmentPresenterImpl
import com.example.peoplecounter.view.MainActivityView
import com.example.peoplecounter.view.WireRequestDomesticView

class LoginFragment : Fragment(), WireRequestDomesticView{
    private lateinit var presenter: LoginFragmentPresenterImpl
    private lateinit var signUp: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = LoginFragmentPresenterImpl(this)
       // lifecycle.addObserver(presenter)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)

//        toolbar = view.findViewById(R.id.toolbar)
//        val activity = activity
//        activity?.setActionBar(toolbar)

        val toolbar = view.findViewById<Toolbar>(R.id.toolbar)
        (requireActivity() as AppCompatActivity).setSupportActionBar(toolbar)

        signUp = view.findViewById(R.id.textViewSignUp)
        signUp.setOnClickListener {
            presenter.onLoginClicked() }
        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu,menu)
    }

    override fun isInternetConnected(): Boolean {
        TODO("Not yet implemented")
    }

    override fun onStartShimmer() {
        TODO("Not yet implemented")
    }

    override fun onStopShimmer() {
        TODO("Not yet implemented")
    }

    override fun onNetworkError() {
        TODO("Not yet implemented")
    }

    override fun showConnectionIssueDialog() {
        TODO("Not yet implemented")
    }

    override fun showError() {
        TODO("Not yet implemented")
    }

    override fun hideError() {
        TODO("Not yet implemented")
    }

    override fun showProgress() {
        TODO("Not yet implemented")
    }

    override fun hideProgress() {
        TODO("Not yet implemented")
    }

    override fun enableAmountCard() {
        TODO("Not yet implemented")
    }

    override fun enableRecipientCard() {
        TODO("Not yet implemented")
    }

    override fun onEnableReviewButton() {
        TODO("Not yet implemented")
    }

    override fun onDisableReviewButton() {
        TODO("Not yet implemented")
    }

    override fun onWireAccountSelect(
        accountName: String?,
        accountType: String?,
        accountBalance: String?
    ) {
        TODO("Not yet implemented")
    }

    override fun disableAccountCard() {
        TODO("Not yet implemented")
    }

    override fun onNoAccountFound() {
        TODO("Not yet implemented")
    }

    override fun updateDate(date: String, isEnableView: Boolean) {
        TODO("Not yet implemented")
    }

    override fun updateAmount(amount: String) {
        TODO("Not yet implemented")
    }

    override fun onAmountBalanceError(message: Int) {
        TODO("Not yet implemented")
    }

    override fun showApiFailureDialog(errorMessage: String) {
        TODO("Not yet implemented")
    }

    override fun showUnrecoverableErrorDialog(title: String, errorMessage: String) {
        TODO("Not yet implemented")
    }

    override fun showResubmitWireRequestDialog(title: String, errorMessage: String) {
        TODO("Not yet implemented")
    }

    override fun showCancelRequestWireTransfer() {
        TODO("Not yet implemented")
    }

    override fun onAccountUsageLimitReached(errorMessageId: Int) {
        TODO("Not yet implemented")
    }

    override fun showPurposeOfWiresFieldError(stringId: Int) {
        TODO("Not yet implemented")
    }

    override fun removePurposeOfWiresFieldError() {
        TODO("Not yet implemented")
    }

    override fun enableCounterForPurposeOfWire() {
        TODO("Not yet implemented")
    }

    override fun showWiresToolTip() {
        TODO("Not yet implemented")
    }

}