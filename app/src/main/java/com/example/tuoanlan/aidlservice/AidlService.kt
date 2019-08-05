package com.example.tuoanlan.aidlservice

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

private val TAG: String = "AIDLService"

class AidlService : Service() {
    private val treeList by lazy { initData() }
    override fun onBind(intent: Intent?): IBinder {
        //返回 Stub 的实现 MyStub
        return MyStub()
    }


    inner class MyStub : ITreePlantCenter.Stub() {

        //实现在 ITreePlantCenter 中定义的接口
        override fun trees(): MutableList<ITree> {
            Log.e(TAG, "读取森林列表")
            return treeList
        }
    }

    /**
     * 初始化treeList
     * */
    private fun initData(): ArrayList<ITree> {
        return arrayListOf(ITree("小白杨"), ITree("垂杨柳"), ITree("刺槐树"))

    }
}