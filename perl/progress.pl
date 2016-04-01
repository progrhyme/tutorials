#!/usr/bin/perl

use strict;
use warnings;
use feature 'say';
use Log::Minimal;

local $| = 1;

for my $i (1..10) {
    print '.' x $i;
    sleep 1;
}
print "\n";
