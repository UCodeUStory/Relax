package com.ustory.relax_business_component.core.viewmodel

import android.app.Application
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.ustory.relax_business_component.app.App
import com.ustory.relax_business_component.core.CoreService
import java.lang.reflect.InvocationTargetException

object MdServiceViewModelFactory : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        try {
            return modelClass.getDeclaredConstructor(Application::class.java, CoreService::class.java)
                .newInstance(App.instance, App.coreService)
        } catch (e: NoSuchMethodException) {
            throw CreateViewModelFailedException(
                modelClass.name + " has no constructor with Application and CoreService", e)
        } catch (e: InstantiationException) {
            throw CreateViewModelFailedException(
                "Failed to instantiation " + modelClass.name, e)
        } catch (e: InvocationTargetException) {
            throw CreateViewModelFailedException(
                "Failed to invoke constructor of " + modelClass.name, e)
        } catch (e: IllegalAccessException) {
            throw CreateViewModelFailedException(
                "Failed to access " + modelClass.name, e)
        }
    }

}