package com.codex.test.base.view.dialog

import com.codex.test.R
import com.codex.test.base.view.dialog.BaseFullScreenDialog

class LoadingDialog : BaseFullScreenDialog() {

    override fun getLayout(): Int {
        return R.layout.dialog_loading
    }

}