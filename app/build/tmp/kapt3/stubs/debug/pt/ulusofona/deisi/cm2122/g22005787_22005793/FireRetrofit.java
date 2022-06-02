package pt.ulusofona.deisi.cm2122.g22005787_22005793;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001e\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0016\u0010\u0010\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\rH\u0016J\u001c\u0010\u0011\u001a\u00020\u00062\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b0\u0012H\u0016J$\u0010\u0011\u001a\u00020\u00062\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b0\u00122\u0006\u0010\u0013\u001a\u00020\u0006H\u0016J\"\u0010\u0014\u001a\u00020\u000b2\u0018\u0010\f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u0004\u0012\u00020\u000b0\u0012H\u0016J$\u0010\u0017\u001a\u00020\u000b2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\rH\u0016J\u001c\u0010\u0019\u001a\u00020\u00062\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b0\u0012H\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lpt/ulusofona/deisi/cm2122/g22005787_22005793/FireRetrofit;", "Lpt/ulusofona/deisi/cm2122/g22005787_22005793/FireModel;", "retrofit", "Lretrofit2/Retrofit;", "(Lretrofit2/Retrofit;)V", "TAG", "", "kotlin.jvm.PlatformType", "service", "Lpt/ulusofona/deisi/cm2122/g22005787_22005793/FiresService;", "addToHistory", "", "onFinished", "Lkotlin/Function0;", "fireData", "Lpt/ulusofona/deisi/cm2122/g22005787_22005793/FireRoom;", "deleteAll", "fogosNaRegiao", "Lkotlin/Function1;", "regiao", "getHistory", "", "Lpt/ulusofona/deisi/cm2122/g22005787_22005793/FireData;", "insertFires", "operations", "totalFogos", "app_debug"})
public final class FireRetrofit extends pt.ulusofona.deisi.cm2122.g22005787_22005793.FireModel {
    private final java.lang.String TAG = null;
    private final pt.ulusofona.deisi.cm2122.g22005787_22005793.FiresService service = null;
    
    public FireRetrofit(@org.jetbrains.annotations.NotNull()
    retrofit2.Retrofit retrofit) {
        super();
    }
    
    @java.lang.Override()
    public void getHistory(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.util.List<pt.ulusofona.deisi.cm2122.g22005787_22005793.FireData>, kotlin.Unit> onFinished) {
    }
    
    @java.lang.Override()
    public void addToHistory(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onFinished, @org.jetbrains.annotations.NotNull()
    pt.ulusofona.deisi.cm2122.g22005787_22005793.FireRoom fireData) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String fogosNaRegiao(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onFinished) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String fogosNaRegiao(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onFinished, @org.jetbrains.annotations.NotNull()
    java.lang.String regiao) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String totalFogos(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onFinished) {
        return null;
    }
    
    @java.lang.Override()
    public void deleteAll(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onFinished) {
    }
    
    @java.lang.Override()
    public void insertFires(@org.jetbrains.annotations.NotNull()
    java.util.List<pt.ulusofona.deisi.cm2122.g22005787_22005793.FireData> operations, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onFinished) {
    }
}