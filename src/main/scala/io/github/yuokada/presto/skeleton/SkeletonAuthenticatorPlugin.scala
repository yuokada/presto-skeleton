package io.github.yuokada.presto.skeleton

import com.facebook.presto.spi.Plugin
import com.facebook.presto.spi.security.PasswordAuthenticatorFactory
import com.google.common.collect.ImmutableList

class SkeletonAuthenticatorPlugin extends Plugin {
  override def getPasswordAuthenticatorFactories: ImmutableList[PasswordAuthenticatorFactory] =
    ImmutableList.builder[PasswordAuthenticatorFactory].add(new SkeletonAuthenticatorFactory).build
}