package pt.ulusofona.deisi.cm2122.g22005787_22005793;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005J\u001b\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000b"}, d2 = {"Lpt/ulusofona/deisi/cm2122/g22005787_22005793/FiresService;", "", "getAll", "Lretrofit2/Response;", "Lpt/ulusofona/deisi/cm2122/g22005787_22005793/GetFiresResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRisk", "Lpt/ulusofona/deisi/cm2122/g22005787_22005793/GetRisk;", "district", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface FiresService {
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "new/fires")
    @retrofit2.http.Headers(value = {"Content-Type: application/json"})
    public abstract java.lang.Object getAll(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<pt.ulusofona.deisi.cm2122.g22005787_22005793.GetFiresResponse>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "v1/risk/{district}")
    @retrofit2.http.Headers(value = {"Content-Type: application/json"})
    public abstract java.lang.Object getRisk(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "district")
    java.lang.String district, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super pt.ulusofona.deisi.cm2122.g22005787_22005793.GetRisk> continuation);
}