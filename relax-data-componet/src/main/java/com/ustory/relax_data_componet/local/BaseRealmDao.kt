package com.ustory.relax_data_componet.local

import io.reactivex.Maybe
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.RealmObject
import timber.log.Timber
import kotlin.reflect.KClass

/**
 * 为保持接口清晰，本类中不使用内联 reified 泛型，要求调用者显式地传递类型信息。
 */
abstract class BaseRealmDao {

    protected abstract val config: RealmConfiguration

    protected fun getRealmInstance(): Realm = Realm.getInstance(config)

    protected fun <T: RealmObject> queryByInternal(clazz: KClass<T>, key: String, value: String): Maybe<T> {
        return Maybe.create { emitter ->
            getRealmInstance().use {
                val result = it
                        .where(clazz.java)
                        .equalTo(key, value)
                        .findFirst()

                if (result != null) {
                    Timber.i("queryByInternal(): ${clazz.java.simpleName} with $key = $value found")
                    emitter.onSuccess(it.copyFromRealm(result))
                } else {
                    Timber.w("queryByInternal(): ${clazz.java.simpleName} with $key = $value not found")
                }

                emitter.onComplete()
            }
        }
    }

    protected fun <T: RealmObject> queryByInternal(clazz: KClass<T>, key: String, value: Int): Maybe<T> {
        return Maybe.create { emitter ->
            getRealmInstance().use {
                val result = it
                        .where(clazz.java)
                        .equalTo(key, value)
                        .findFirst()

                if (result != null) {
                    Timber.i("queryByInternal(): ${clazz.java.simpleName} with $key = $value found")
                    emitter.onSuccess(it.copyFromRealm(result))
                } else {
                    Timber.w("queryByInternal(): ${clazz.java.simpleName} with $key = $value not found")
                }

                emitter.onComplete()
            }
        }
    }

    protected fun <T: RealmObject> queryAllInternal(clazz: KClass<T>): Maybe<List<T>> {
        return Maybe.create { emitter ->
            getRealmInstance().use {
                val result = it
                        .where(clazz.java)
                        .findAll()

                if (!result.isEmpty()) {
                    Timber.i("queryAllInternal(): Query ${clazz.java.simpleName} found, size = ${result.size}")
                    emitter.onSuccess(it.copyFromRealm(result))
                } else {
                    Timber.i("queryAllInternal(): Query ${clazz.java.simpleName} not found")
                }

                emitter.onComplete()
            }
        }
    }



    protected fun <T: RealmObject> queryFirstInternal(clazz: KClass<T>): Maybe<T> {
        return Maybe.create { emitter ->
            getRealmInstance().use {
                val result = it
                        .where(clazz.java)
                        .findFirst()

                if (result != null) {
                    Timber.i("queryFirstInternal(): Query ${clazz.java.simpleName} found")
                    emitter.onSuccess(it.copyFromRealm(result))
                } else {
                    Timber.i("queryFirstInternal(): Query ${clazz.java.simpleName} not found")
                }

                emitter.onComplete()
            }
        }
    }

    protected fun <T: RealmObject> insertOrUpdateInternal(data: T) {
        val realm = getRealmInstance()
        realm.executeTransaction {
            realm.insertOrUpdate(data)
        }
        Timber.v("insertOrUpdateInternal(): insert $data")
        realm.close()
    }

    protected fun <T: RealmObject> insertOrReplaceInternal(clazz: KClass<T>, data: T) {
        getRealmInstance().use {
            val result = it
                    .where(clazz.java)
                    .findAll()

            Timber.v("insertOrReplaceInternal(): remove ${result.size} outdated records")
            Timber.v("insertOrReplaceInternal(): insert $data")

            it.executeTransaction {
                result.deleteAllFromRealm()
                it.insert(data)
            }
        }
    }

    protected fun <T: RealmObject> insertOrReplaceListInternal(clazz: KClass<T>, data: List<T>) {
        getRealmInstance().use {
            val result = it
                    .where(clazz.java)
                    .findAll()

            Timber.v("insertOrReplaceListInternal(): remove ${result.size} outdated records")
            Timber.v("insertOrReplaceListInternal(): insert list size ${data.size}, $data")

            it.executeTransaction {
                result.deleteAllFromRealm()
                it.insert(data)
            }
        }
    }

    protected fun <T: RealmObject> deleteInternal(clazz: KClass<T>, key: String, value: String) {
        getRealmInstance().use {
            val result = it
                    .where(clazz.java)
                    .equalTo(key, value)
                    .findAll()

            Timber.v("delete(): remove ${result.size} outdated records")
            if (result.isNotEmpty()) {
                Timber.v("delete(): first item is ${result[0]}")
            }

            it.executeTransaction {
                result.deleteAllFromRealm()
            }
        }
    }

    protected fun <T: RealmObject> queryByInternalSync(clazz: KClass<T>, key: String, value: Int): T? {
            getRealmInstance().use {
                val result = it
                        .where(clazz.java)
                        .equalTo(key, value)
                        .findFirst()
                return if (result != null) {
                    Timber.i("queryByInternal(): ${clazz.java.simpleName} with $key = $value found")
                    result
                } else {
                    Timber.w("queryByInternal(): ${clazz.java.simpleName} with $key = $value not found")
                    null
                }
            }
    }

}