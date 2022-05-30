package pt.ulusofona.deisi.cm2122.g22005787_22005793;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001c\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u0007J\u0006\u0010\u001b\u001a\u00020\u0014J\u0006\u0010\u001c\u001a\u00020\u0007J\u000e\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0007J \u0010\u001d\u001a\u00020\u00142\u0018\u0010\u0015\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f\u0012\u0004\u0012\u00020\u00140\u001eJ\u0006\u0010!\u001a\u00020\u0007J\u0006\u0010\"\u001a\u00020\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u001a\u0010\u000b\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f\u00a8\u0006#"}, d2 = {"Lpt/ulusofona/deisi/cm2122/g22005787_22005793/FireModel;", "", "dao", "Lpt/ulusofona/deisi/cm2122/g22005787_22005793/FireDao;", "(Lpt/ulusofona/deisi/cm2122/g22005787_22005793/FireDao;)V", "districts", "", "", "getDistricts", "()[Ljava/lang/String;", "[Ljava/lang/String;", "region", "getRegion", "()Ljava/lang/String;", "setRegion", "(Ljava/lang/String;)V", "risk", "getRisk", "setRisk", "addToHistory", "", "onFinished", "Lkotlin/Function0;", "fireData", "Lpt/ulusofona/deisi/cm2122/g22005787_22005793/FireRoom;", "alterarRegiao", "regiao", "alterarRisco", "fogosNaRegiao", "getHistory", "Lkotlin/Function1;", "", "Lpt/ulusofona/deisi/cm2122/g22005787_22005793/FireData;", "mediaFogosNaRegiao", "totalFogos", "app_debug"})
public final class FireModel {
    private final pt.ulusofona.deisi.cm2122.g22005787_22005793.FireDao dao = null;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String region = "Lisboa";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String risk;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String[] districts = {"Aveiro", "Beja", "Braga", "Bragan\u00e7a", "Castelo Branco", "Coimbra", "\u00c9vora", "Faro", "Guarda", "Leiria", "Lisboa", "Portalegre", "Porto", "Santar\u00e9m", "Set\u00fabal", "Viana do Castelo", "Vila Real", "Viseu"};
    
    public FireModel(@org.jetbrains.annotations.NotNull()
    pt.ulusofona.deisi.cm2122.g22005787_22005793.FireDao dao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRegion() {
        return null;
    }
    
    public final void setRegion(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRisk() {
        return null;
    }
    
    public final void setRisk(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String[] getDistricts() {
        return null;
    }
    
    public final void getHistory(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.util.List<pt.ulusofona.deisi.cm2122.g22005787_22005793.FireData>, kotlin.Unit> onFinished) {
    }
    
    public final void addToHistory(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onFinished, @org.jetbrains.annotations.NotNull()
    pt.ulusofona.deisi.cm2122.g22005787_22005793.FireRoom fireData) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String fogosNaRegiao() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String fogosNaRegiao(@org.jetbrains.annotations.NotNull()
    java.lang.String regiao) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String totalFogos() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String mediaFogosNaRegiao() {
        return null;
    }
    
    public final void alterarRegiao(@org.jetbrains.annotations.NotNull()
    java.lang.String regiao) {
    }
    
    public final void alterarRisco() {
    }
}