package com.botpy.digiccy.util;

import com.botpy.digiccy.api.exception.ApiException;
import com.botpy.digiccy.model.Result;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * @author liuxuhui
 * @date 2018/11/18
 */
public class RxUtil {

    /**
     * 线程统一控制方法
     * @param <T>
     * @return
     */
    public static <T> FlowableTransformer<T, T> applySchedlers() {
        return transformer -> transformer.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    /**
     * 处理返回结果
     */
    public static <T> FlowableTransformer<Result<T>, T> handleResult() {
        return upstream -> upstream.flatMap((Function<Result<T>, Flowable<T>>) tResult -> {
            if (tResult.success == true && tResult.code == 200) {
                return handleData(tResult.data);
            }else {
                return Flowable.error(new ApiException(tResult.code, tResult.message));
            }
        });
    }

    public static <T> Flowable<T> handleData(T t) {
        return Flowable.create(emitter -> {
            try {
                emitter.onNext(t);
                emitter.onComplete();
            }catch (Exception e) {
                emitter.onError(e);
            }
        }, BackpressureStrategy.BUFFER);
    }
}
