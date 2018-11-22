package io.github.yuokada.presto.skeleton

import java.security.Principal

import com.facebook.presto.spi.security.{BasicPrincipal, PasswordAuthenticator}
import io.airlift.log.Logger

object SkeletonAuthenticator {
  private val log = Logger.get(classOf[SkeletonAuthenticator])
}

class SkeletonAuthenticator() extends PasswordAuthenticator {
  override def createAuthenticatedPrincipal(user: String, password: String): Principal = {
    SkeletonAuthenticator.log.info("Skeleton Plugin is working.")
    new BasicPrincipal(user)
  }
}