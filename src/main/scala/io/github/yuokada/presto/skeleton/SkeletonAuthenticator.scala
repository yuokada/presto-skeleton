package io.github.yuokada.presto.skeleton

import java.security.Principal

import com.facebook.presto.spi.security.{BasicPrincipal, PasswordAuthenticator}
import io.airlift.log.Logger

class SkeletonAuthenticator() extends PasswordAuthenticator {
  private val log = Logger.get(classOf[SkeletonAuthenticator])

  override def createAuthenticatedPrincipal(user: String, password: String): Principal = {
    log.info("Skeleton Plugin is working.")
    new BasicPrincipal(user)
  }
}