package pt.ulusofona.deisi.cm2122.g22005787_22005793;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\bJ(\u0010\t\u001a\u00020\n2\u0018\u0010\u000b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\n0\f2\u0006\u0010\u000f\u001a\u00020\bJ \u0010\u0010\u001a\u00020\n2\u0018\u0010\u000b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\n0\fJ \u0010\u0011\u001a\u00020\n2\u0018\u0010\u000b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\n0\fJ \u0010\u0012\u001a\u00020\n2\u0018\u0010\u000b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\n0\fJ\u001c\u0010\u0013\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u001c\u0010\u0017\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00142\u0006\u0010\u000f\u001a\u00020\bJ\u001a\u0010\u0018\u001a\u00020\b2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\n0\fJ\"\u0010\u0018\u001a\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\n0\f2\u0006\u0010\u000f\u001a\u00020\bJ \u0010\u0019\u001a\u00020\n2\u0018\u0010\u000b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\n0\fJ\u0006\u0010\u001a\u001a\u00020\bJ\"\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\b2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\n0\fJ\u001a\u0010\u001d\u001a\u00020\b2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\n0\fJ\u001a\u0010\u001e\u001a\u00020\b2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\n0\fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lpt/ulusofona/deisi/cm2122/g22005787_22005793/FireViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "model", "Lpt/ulusofona/deisi/cm2122/g22005787_22005793/FireRepository;", "getFilter", "", "getOnFogosNaRegiao", "", "onFinished", "Lkotlin/Function1;", "", "Lpt/ulusofona/deisi/cm2122/g22005787_22005793/FireData;", "regiao", "meiosAereos", "meiosOperacionais", "meiosTerrestres", "onAddToHistory", "Lkotlin/Function0;", "fireData", "Lpt/ulusofona/deisi/cm2122/g22005787_22005793/FireRoom;", "onAlterarRegiao", "onFogosNaRegiao", "onGetHistory", "onGetRegiaoFilter", "onGetRisk", "distrito", "onMediaFogosNaRegiao", "onTotalFogos", "app_debug"})
public final class FireViewModel extends androidx.lifecycle.AndroidViewModel {
    private final pt.ulusofona.deisi.cm2122.g22005787_22005793.FireRepository model = null;
    
    public FireViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super(null);
    }
    
    public final void onGetHistory(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.util.List<pt.ulusofona.deisi.cm2122.g22005787_22005793.FireData>, kotlin.Unit> onFinished) {
    }
    
    public final void onAddToHistory(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onFinished, @org.jetbrains.annotations.NotNull()
    pt.ulusofona.deisi.cm2122.g22005787_22005793.FireRoom fireData) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String onFogosNaRegiao(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onFinished) {
        return null;
    }
    
    public final void onFogosNaRegiao(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onFinished, @org.jetbrains.annotations.NotNull()
    java.lang.String regiao) {
    }
    
    public final void getOnFogosNaRegiao(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.util.List<pt.ulusofona.deisi.cm2122.g22005787_22005793.FireData>, kotlin.Unit> onFinished, @org.jetbrains.annotations.NotNull()
    java.lang.String regiao) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String onTotalFogos(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onFinished) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String onMediaFogosNaRegiao(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onFinished) {
        return null;
    }
    
    public final void onAlterarRegiao(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onFinished, @org.jetbrains.annotations.NotNull()
    java.lang.String regiao) {
    }
    
    public final void onGetRisk(@org.jetbrains.annotations.NotNull()
    java.lang.String distrito, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onFinished) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String onGetRegiaoFilter() {
        return null;
    }
    
    public final void meiosOperacionais(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.util.List<pt.ulusofona.deisi.cm2122.g22005787_22005793.FireData>, kotlin.Unit> onFinished) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFilter() {
        return null;
    }
    
    public final void meiosTerrestres(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.util.List<pt.ulusofona.deisi.cm2122.g22005787_22005793.FireData>, kotlin.Unit> onFinished) {
    }
    
    public final void meiosAereos(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.util.List<pt.ulusofona.deisi.cm2122.g22005787_22005793.FireData>, kotlin.Unit> onFinished) {
    }
}