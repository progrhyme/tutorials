#!/usr/bin/perl

use strict;
use warnings;
use feature 'say';
use Log::Minimal;

my %a = (foo => 1, bar => 2);
my %b = (foo => 100, baz => 200);

%a = (%b, %a);
infof ddf(\%a);
infof ddf(\%b);
