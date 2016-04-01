#!/usr/bin/env perl

use strict;
use warnings;

use File::Temp 'tempdir';
use IO::Socket::UNIX;

my $dir  = tempdir( CLEANUP => 1 );
my $path = $dir . '/test-unix.sock';
print "$path\n";

my $server = IO::Socket::UNIX->new(
    Type   => SOCK_STREAM(),
    Local  => $path,
    Listen => 1,
);

use Data::Dumper;
print Dumper $server;

exit 1 unless $server;

local $SIG{INT} = local $SIG{TERM} = sub {
    $server->close();
};

my $count = 1;
while (my $conn = $server->accept()) {
    $conn->print("Hello " . ($count++) . "\n");
}
