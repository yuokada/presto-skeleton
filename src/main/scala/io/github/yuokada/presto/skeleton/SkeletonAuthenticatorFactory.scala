package io.github.yuokada.presto.skeleton

import java.util

import com.facebook.presto.spi.security.{PasswordAuthenticator, PasswordAuthenticatorFactory}
import com.google.common.base.Throwables.throwIfUnchecked
import com.google.inject.{Binder, Scopes}
import io.airlift.bootstrap.Bootstrap

class SkeletonAuthenticatorFactory extends PasswordAuthenticatorFactory {
  override def getName = "skeleton"

  override def create(config: util.Map[String, String]): PasswordAuthenticator = try {
    val app = new Bootstrap((binder: Binder) => {
        binder.bind(classOf[SkeletonAuthenticator]).in(Scopes.SINGLETON)
    })
    val injector = app.strictConfig.doNotInitializeLogging().setRequiredConfigurationProperties(config).initialize
    injector.getInstance(classOf[SkeletonAuthenticator])
  } catch {
    case e: Exception =>
      throwIfUnchecked(e)
      throw new RuntimeException(e)
  }
}