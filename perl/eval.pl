#!/usr/bin/env perl
case2();

sub case2 {
  my $r = 1;
  $r = eval {
    my $a = 3;
  };
  print defined($r)?$r:"not defined","\n"; # 2
}
