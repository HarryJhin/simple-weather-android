package blog.jinhyun.simpleweatherandroid.convention

import com.android.build.api.dsl.AndroidResources
import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.ApplicationProductFlavor
import com.android.build.api.dsl.BuildFeatures
import com.android.build.api.dsl.BuildType
import com.android.build.api.dsl.CommonExtension
import com.android.build.api.dsl.DefaultConfig
import com.android.build.api.dsl.Installation
import com.android.build.api.dsl.ProductFlavor

fun <BuildFeaturesT : BuildFeatures,
    BuildTypeT : BuildType,
    DefaultConfigT : DefaultConfig,
    ProductFlavorT : ProductFlavor,
    AndroidResourcesT : AndroidResources,
    InstallationT : Installation> configureFlavors(
    extension: CommonExtension<
        BuildFeaturesT,
        BuildTypeT,
        DefaultConfigT,
        ProductFlavorT,
        AndroidResourcesT,
        InstallationT>
) {
    with(extension) {
        flavorDimensions += AppFlavorDimension.contentType.name
        productFlavors {
            AppProductFlavor.values().forEach {
                create(it.name) {
                    dimension = it.dimension.name

                    // BuildConfig.isDemo 변수 추가
                    if (buildFeatures.buildConfig == true) {
                        buildConfigField(
                            "Boolean",
                            "isDemo",
                            (it == AppProductFlavor.demo).toString()
                        )
                    }

                    if (this@with is ApplicationExtension && this is ApplicationProductFlavor) {
                        if (it.applicationIdSuffix != null) {
                            applicationIdSuffix = it.applicationIdSuffix
                        }
                    }
                }
            }
        }
    }
}